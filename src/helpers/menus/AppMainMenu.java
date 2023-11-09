package helpers.menus;

import car.Car;
import exceptions.NegativeValueException;
import exceptions.NotNumberException;
import exceptions.OutOfMenuBoundsException;
import helpers.ObjectsCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static car.SparePart.calcSparePartCost;
import static helpers.ConsoleColors.*;
import static persons.Customer.showCustomers;
import static persons.Mechanic.showMechanics;

public final class AppMainMenu {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();
    private static final AutoServMenu AUTO_SERV_MENU = new AutoServMenu();

    // Setup Logger log4j2
    static {
        System.setProperty("log4j.configurationFile", "lib/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    // Greeting a customer
    static {
        LOGGER.info(
                String.format("%sДобро пожаловать в автосервис '4 колеса'!%s", ANSI_GREEN, ANSI_RESET)
        );
    }

    Car car = new Car();

    public final void mainMenu() throws NotNumberException {
        try (Scanner scanner = new Scanner(System.in)) {
            // Main menu
            boolean exit = false;
            int option;

            while (!exit) {
                LOGGER.info(
                        String.format("%sПожалуйста, выберите одну из предложенных операций: %s",
                                ANSI_GREEN, ANSI_RESET)
                );
                LOGGER.info("[1]. Показать список услуг автосервиса");
                LOGGER.info("[2]. Показать список клиентов автосервиса");
                LOGGER.info("[3]. Показать список машин обслуживающихся в автосервисе");
                LOGGER.info("[4]. Магазин автозапчастей");
                LOGGER.info("[5]. Показать список автомехаников");
                LOGGER.info("[0]. Выйти из программы");

                while (true) {
                    if (scanner.hasNextInt()) {
                        option = scanner.nextInt();
                        break;
                    } else {
                        throw new NotNumberException("Вместо числа введена строка", scanner.next());
                    }
                }

                // Check value in accepted range
                if (option > 5) {
                    option = 6;
                }

                switch (option) {
                    case 0 -> exit = true;
                    case 1 -> AUTO_SERV_MENU.autoServMenu(scanner, exit);
                    case 2 -> showCustomers(OBJECTS_CREATOR.customers);
                    case 3 -> car.showCars(OBJECTS_CREATOR.cars);
                    case 4 -> calcSparePartCost(OBJECTS_CREATOR.cars, OBJECTS_CREATOR.spareParts);
                    case 5 -> showMechanics(OBJECTS_CREATOR.mechanics);
                    case 6 -> throw new OutOfMenuBoundsException(
                            "Введён пункт меню " + option + " свыше доступных", option - 1);
                    case -1 -> throw new NegativeValueException("Введено негативное число", option);
                    default -> LOGGER.info(
                            String.format("%sНеверная операция, попробуйте ещё раз!%s\n",
                                    ANSI_RED, ANSI_RESET)
                    );
                }
            }
        } catch (NegativeValueException e) {
            LOGGER.debug(ANSI_RED +
                    "Ой, ошибочка! " + e + " " + e.getNumber() + "."
                    + " В классе: " + getClass() + ANSI_RESET);
        } catch (OutOfMenuBoundsException e) {
            LOGGER.debug(ANSI_RED +
                    "Ой, ошибочка! " + e + " " + e.getNumber() + "."
                    + " В классе: " + getClass());
        }
    }
}
