package helpers.menus;

import helpers.ObjectsCreator;

import java.util.Scanner;

import static car.CarDiagnostics.checkCar;
import static helpers.ConsoleColors.*;

public final class CarDiagnosticsMenu {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    // Car diagnostics menu
    public static void diagnosticsServiceMenu(Scanner scanner, boolean exit) {
        System.out.printf("%sВыберите авто для диагностики%s\n", ANSI_GREEN, ANSI_RESET);
        System.out.println("[1]. Диагностика BMW X6");
        System.out.println("[2]. Диагностика Toyota LandCruiser");
        System.out.println("[3]. Диагностика Mercedes Benz");
        System.out.println("[0]. Выход");

        int option;

        while (true) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                break;
            } else {
                System.out.println(
                        ANSI_RED + "Вы ввели неверный номер, попробуйте ещё раз!" + ANSI_RESET
                );
                scanner.next();
            }
        }

        while (!exit) {
            switch (option) {
                case 0 -> exit = true;
                case 1 -> checkCar(OBJECTS_CREATOR.bmwX6Diagnostics);
                case 2 -> checkCar(OBJECTS_CREATOR.toyotaLandCruiserDiagnostics);
                case 3 -> checkCar(OBJECTS_CREATOR.mercedesBenzDiagnostics);
                default -> System.out.printf(
                        "%sНеверная операция, попробуйте ещё раз!%s\n", ANSI_RED, ANSI_RESET
                );
            }
            break;
        }
    }
}
