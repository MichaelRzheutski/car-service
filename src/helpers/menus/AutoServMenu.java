package helpers.menus;

import exceptions.NegativeValueException;
import exceptions.NotNumberException;
import exceptions.OutOfMenuBoundsException;
import helpers.ObjectsCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static helpers.ConsoleColors.*;
import static helpers.calcs.RepCostCalc.calcRepCost;
import static helpers.calcs.RepTimeCalc.calculateRepTime;

public final class AutoServMenu {
    CarDiagMenu carDiagMenu = new CarDiagMenu();
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    // Setup Logger log4j2
    static {
        System.setProperty("log4j.configurationFile", "lib/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    // AutoService menu
    public void autoServMenu(Scanner scanner, boolean isExit) throws NotNumberException {
        int option;

        try {
            while (!isExit) {
                LOGGER.info(
                        String.format("%sУслуги доступные у нас в автосервисе:%s",
                                ANSI_GREEN, ANSI_RESET)
                );
                LOGGER.info("[1]. Диагностика автомобиля");
                LOGGER.info("[2]. Рассчитать время ремонта автомобиля");
                LOGGER.info("[3]. Рассчитать стоимость ремонта автомобиля");
                LOGGER.info("[0]. Выход");

                while (true) {
                    if (scanner.hasNextInt()) {
                        option = scanner.nextInt();
                        break;
                    } else {
                        throw new NotNumberException("Вместо числа введена строка", scanner.next());
                    }
                }

                // Check value in accepted range, if out of range
                // throw the OutOfMenuBoundsException
                if (option > 3) {
                    option = 4;
                }

                switch (option) {
                    case 0 -> isExit = true;
                    case 1 -> carDiagMenu.diagServiceMenu(scanner, isExit);
                    case 2 -> calculateRepTime(scanner, isExit);
                    case 3 -> calcRepCost(scanner, isExit, OBJECTS_CREATOR.createInvoiceList());
                    case 4 -> throw new OutOfMenuBoundsException(
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
