package helpers.menus;

import java.util.Scanner;

import static helpers.ConsoleColors.*;
import static helpers.calculators.RepairmentCostCalculator.calculateRepairmentCost;
import static helpers.calculators.RepairmentTimeCalculator.calculateRepairmentTime;
import static helpers.menus.CarDiagnosticsMenu.diagnosticsServiceMenu;

public class AutoServiceMenu {
    // AutoService menu
    public static void autoServiceMenu(Scanner scanner, boolean exit) {
        System.out.printf("%sУслуги доступные у нас в автосервисе%s\n", ANSI_GREEN, ANSI_RESET);
        System.out.println("[1]. Диагностика автомобиля");
        System.out.println("[2]. Рассчитать время ремонта автомобиля");
        System.out.println("[3]. Рассчитать стоимость ремонта автомобиля");
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
                case 1 -> diagnosticsServiceMenu(scanner, exit);
                case 2 -> calculateRepairmentTime(scanner, exit);
                case 3 -> calculateRepairmentCost(scanner, exit);
                default -> System.out.printf(
                        "%sНеверная операция, попробуйте ещё раз!%s\n", ANSI_RED, ANSI_RESET
                );
            }
            break;
        }
    }
}
