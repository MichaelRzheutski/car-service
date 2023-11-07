package helpers.menus;

import car.Car;
import helpers.ObjectsCreator;

import java.util.Scanner;

import static car.SparePart.calculateSparePartCost;
import static helpers.ConsoleColors.*;
import static helpers.menus.AutoServiceMenu.autoServiceMenu;
import static persons.Customer.showCustomers;

public final class AppMainMenu {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    // Greeting a customer
    static {
        System.out.printf(
                "%sДобро пожаловать в автосервис '4 колеса'!%s\n", ANSI_GREEN, ANSI_RESET
        );
    }

    Car car = new Car();

    public final void mainMenu() {
        // Main menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.printf(
                    "%sПожалуйста, выберите одну из предложенных операций: %s\n",
                    ANSI_GREEN, ANSI_RESET
            );
            System.out.println("[1]. Показать список услуг автосервиса");
            System.out.println("[2]. Показать список клиентов автосервиса");
            System.out.println("[3]. Показать список машин обслуживающихся в автосервисе");
            System.out.println("[4]. Магазин автозапчастей");
            System.out.println("[0]. Выйти из программы");

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

            switch (option) {
                case 0 -> exit = true;
                case 1 -> autoServiceMenu(scanner, exit);
                case 2 -> showCustomers(OBJECTS_CREATOR.customers);
                case 3 -> car.showCars(OBJECTS_CREATOR.cars);
                case 4 -> calculateSparePartCost(OBJECTS_CREATOR.spareParts, OBJECTS_CREATOR.cars);
                default -> System.out.printf(
                        "%sНеверная операция, попробуйте ещё раз!%s\n",
                        ANSI_RED, ANSI_RESET
                );
            }
        }
    }


}
