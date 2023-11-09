package helpers.calcs;

import helpers.ObjectsCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static helpers.ConsoleColors.*;

public final class RepCostCalc {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    // Setup Logger log4j2
    static {
        System.setProperty("log4j.configurationFile", "lib/log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger();

    // Calculate car repairment cost
    public static double calcRepCost(
            Scanner scanner, boolean exit
    ) {
        LOGGER.info(ANSI_GREEN + "Выберите автомобиль" + ANSI_RESET);
        LOGGER.info("[1]. BMW X6");
        LOGGER.info("[2]. Toyota Land Cruiser");
        LOGGER.info("[3]. Mercedes Benz");
        LOGGER.info("[0]. Выход");

        int option = scanner.nextInt();
        scanner.nextLine();

        double alexeyPrivolnovInvoice = 0;
        double sergeyVlasovInvoice = 0;
        double vladimirDolginInvoice = 0;
        double result = 0;

        while (!exit) {
            switch (option) {
                case 0 -> exit = true;
                case 1 -> {
                    alexeyPrivolnovInvoice = repCostCalculator(
                            OBJECTS_CREATOR.bmwX6Diagnostics.getCarForDiagnostics().getCarManufactureYear(),
                            OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsResult(),
                            OBJECTS_CREATOR.bmwX6Diagnostics.getDamagesSeverity(),
                            OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
                    );
                    LOGGER.info(ANSI_GREEN + "Общая стоимость ремонта " +
                            OBJECTS_CREATOR.bmwX6Diagnostics.getCarForDiagnostics().getCarMake() + ": " + ANSI_YELLOW +
                            alexeyPrivolnovInvoice + "\n" + ANSI_RESET
                    );
                    result = alexeyPrivolnovInvoice;
                }
                case 2 -> {
                    sergeyVlasovInvoice = repCostCalculator(
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getCarManufactureYear(),
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDiagnosticsResult(),
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDamagesSeverity(),
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDiagnosticsTime()
                    );
                    LOGGER.info(ANSI_GREEN + "Общая стоимость ремонта " +
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getCarForDiagnostics().getCarMake() + ": " + ANSI_YELLOW +
                            sergeyVlasovInvoice + "\n" + ANSI_RESET
                    );
                    result = sergeyVlasovInvoice;
                }
                case 3 -> {
                    vladimirDolginInvoice = repCostCalculator(
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getCarManufactureYear(),
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getDiagnosticsResult(),
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getDamagesSeverity(),
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getDiagnosticsTime()
                    );
                    LOGGER.info(ANSI_GREEN + "Общая стоимость ремонта " +
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getCarForDiagnostics().getCarMake() + ": " + ANSI_YELLOW +
                            vladimirDolginInvoice + "\n" + ANSI_RESET
                    );
                    result = vladimirDolginInvoice;
                }
                default -> LOGGER.info(
                        String.format("%sНеверная операция, попробуйте ещё раз!%s\n",
                                ANSI_RED, ANSI_RESET)
                );
            }
            break;
        }
        return result;
    }

    // Method checks car manufacture year and
    // returns repairment cost depends on year
    public static double checkCarManufactureYear(
            int carManufactureYear, double repairmentCost,
            String name, String surname
    ) {
        double totalRepairmentCost = repairmentCost;
        String nameAndSurname = name + " " + surname;

        if (carManufactureYear >= 2021 && carManufactureYear < 2025) {
            totalRepairmentCost *= 1.5;
        }

        switch (nameAndSurname) {
            case "Алексей Привольнов" -> OBJECTS_CREATOR.alexeyPrivolnovInvoice.setTotalCost(totalRepairmentCost);
            case "Сергей Власов" -> OBJECTS_CREATOR.sergeyVlasovInvoice.setTotalCost(totalRepairmentCost);
            case "Владимир Долгин" -> OBJECTS_CREATOR.vladimirDolginInvoice.setTotalCost(totalRepairmentCost);
            default -> LOGGER.info("Такого клиента не существует");
        }

        return totalRepairmentCost;
    }

    // Method checks diagnostics result and adds additional price to repairment cost
    // depends on diagnostics result
    public static double checkDiagnosticsResult(
            String diagnosticsResult, double repairmentCost,
            String name, String surname, int diagnosticsTime
    ) {
        double totalRepairmentCost = repairmentCost;
        int totalDiagnosticsTime = diagnosticsTime;
        String nameAndSurname = name + " " + surname;

        if (diagnosticsResult.equals("Требуется замена моторного масла")) {
            totalRepairmentCost += 20.00;
        }

        if (diagnosticsResult.equals("Требуется замена шин")) {
            totalRepairmentCost += 50.00;
            totalDiagnosticsTime += 1;
        }

        if (diagnosticsResult.equals("Требуется замена тормозных колодок")) {
            totalRepairmentCost += 80.00;
            totalDiagnosticsTime += 2;
        }

        switch (nameAndSurname) {
            case "Алексей Привольнов" -> {
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.setTotalCost(totalRepairmentCost);
                OBJECTS_CREATOR.bmwX6Diagnostics.setDiagnosticsTime(totalDiagnosticsTime);
            }
            case "Сергей Власов" -> {
                OBJECTS_CREATOR.sergeyVlasovInvoice.setTotalCost(totalRepairmentCost);
                OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.setDiagnosticsTime(totalDiagnosticsTime);
            }
            case "Владимир Долгин" -> {
                OBJECTS_CREATOR.vladimirDolginInvoice.setTotalCost(totalRepairmentCost);
                OBJECTS_CREATOR.mercedesBenzDiagnostics.setDiagnosticsTime(totalDiagnosticsTime);
            }
            default -> LOGGER.info(String.format("%sТакого клиента не существует!%s\n", ANSI_RED, ANSI_RESET)
            );
        }

        return totalRepairmentCost;
    }

    // Method checks car damages severity
    public static double checkDamagesSeverity(
            String damagesSeverity, double repairmentCost,
            String name, String surname, int diagnosticsTime
    ) {
        double totalRepairmentCost = repairmentCost;
        int totalDiagnosticsTime = diagnosticsTime;
        String nameAndSurname = name + " " + surname;

        if (damagesSeverity.equals("Лёгкие повреждения")) {
            totalRepairmentCost += 30.00;
            totalDiagnosticsTime += 1;
        }

        if (damagesSeverity.equals("Серьёзные повреждения")) {
            totalRepairmentCost += 50.00;
            totalDiagnosticsTime += 2;
        }

        switch (nameAndSurname) {
            case "Алексей Привольнов" -> {
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.setTotalCost(totalRepairmentCost);
                OBJECTS_CREATOR.bmwX6Diagnostics.setDiagnosticsTime(totalDiagnosticsTime);
            }
            case "Сергей Власов" -> {
                OBJECTS_CREATOR.sergeyVlasovInvoice.setTotalCost(totalRepairmentCost);
                OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.setDiagnosticsTime(totalDiagnosticsTime);
            }
            case "Владимир Долгин" -> {
                OBJECTS_CREATOR.vladimirDolginInvoice.setTotalCost(totalRepairmentCost);
                OBJECTS_CREATOR.mercedesBenzDiagnostics.setDiagnosticsTime(totalDiagnosticsTime);
            }
            default -> LOGGER.info(String.format("%sТакого клиента не существует!%s\n", ANSI_RED, ANSI_RESET)
            );
        }

        return totalRepairmentCost;
    }

    // Method calculates total cost of repairment
    public static double repCostCalculator(
            int carManufactureYear, String diagnosticsResult,
            String damagesSeverity, int diagnosticsTime
    ) {
        double totalRepairmentCost;

        totalRepairmentCost = checkCarManufactureYear(
                OBJECTS_CREATOR.bmwX6.getCarManufactureYear(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname()
        );

        totalRepairmentCost = checkDiagnosticsResult(
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsResult(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname(),
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
        );

        totalRepairmentCost = checkDamagesSeverity(
                OBJECTS_CREATOR.bmwX6Diagnostics.getDamagesSeverity(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname(),
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
        );

        return totalRepairmentCost;
    }
}
