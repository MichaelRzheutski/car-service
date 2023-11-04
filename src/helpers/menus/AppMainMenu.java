package helpers.menus;

import helpers.ObjectsCreator;

import java.util.Scanner;

import static car.Car.showCars;
import static carservice.SparePartsShop.showSparePartsInStore;
import static helpers.ConsoleColors.*;
import static helpers.menus.AutoServiceMenu.autoServiceMenu;
import static persons.Customer.showCustomers;

public class AppMainMenu {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    public static void mainMenu() {
        // Main menu
        System.out.printf(
                "%sДобро пожаловать в автосервис '4 колеса'!%s\n", ANSI_GREEN, ANSI_RESET
        );
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
            System.out.println("[0]. Выйти");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0 -> exit = true;
                case 1 -> autoServiceMenu(scanner, exit);
                case 2 -> showCustomers(OBJECTS_CREATOR.customers);
                case 3 -> showCars(OBJECTS_CREATOR.cars);
                case 4 -> showSparePartsInStore(OBJECTS_CREATOR.sparePartsInShop);
                default -> System.out.printf(
                        "%sНеверная операция, попробуйте ещё раз!%s\n",
                        ANSI_RED, ANSI_RESET
                );
            }
        }

    }
}
