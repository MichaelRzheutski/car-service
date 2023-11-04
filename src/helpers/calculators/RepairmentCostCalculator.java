package helpers.calculators;

import helpers.ObjectsCreator;
import helpers.cars.CarYears;

import java.util.Scanner;

import static helpers.ConsoleColors.*;

public class RepairmentCostCalculator {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    // Calculate car repairment cost
    public static void calculateRepairmentCost(
            Scanner scanner, boolean exit
    ) {
        System.out.println(ANSI_GREEN + "Выберите автомобиль" + ANSI_RESET);
        System.out.println("[1]. BMW X6");
        System.out.println("[2]. Toyota Land Cruiser");
        System.out.println("[3]. Mercedes Benz");
        System.out.println("[0]. Выход");

        int option = scanner.nextInt();
        scanner.nextLine();

        while (!exit) {
            switch (option) {
                case 0 -> exit = true;
                case 1 -> repairmentCostCalculator(
                        OBJECTS_CREATOR.bmwX6Diagnostics.getCarForDiagnostics().getCarManufactureYear(),
                        OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsResult(),
                        OBJECTS_CREATOR.bmwX6Diagnostics.getDamagesSeverity(),
                        OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
                );
                case 2 -> repairmentCostCalculator(
                        OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getCarManufactureYear(),
                        OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDiagnosticsResult(),
                        OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDamagesSeverity(),
                        OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDiagnosticsTime()
                );
                case 3 -> repairmentCostCalculator(
                        OBJECTS_CREATOR.mercedesBenzDiagnostics.getCarManufactureYear(),
                        OBJECTS_CREATOR.mercedesBenzDiagnostics.getDiagnosticsResult(),
                        OBJECTS_CREATOR.mercedesBenzDiagnostics.getDamagesSeverity(),
                        OBJECTS_CREATOR.mercedesBenzDiagnostics.getDiagnosticsTime()
                );
                default -> System.out.printf(
                        "%sНеверная операция, попробуйте ещё раз!%s\n",
                        ANSI_RED, ANSI_RESET
                );
            }
            break;
        }
    }

    // Method checks car manufacture year
    public static void checkCarManufactureYear(
            CarYears carManufactureYear, double repairmentCost,
            String name, String surname
    ) {
        double totalRepairmentCost = repairmentCost;
        String nameAndSurname = name + " " + surname;

        if (carManufactureYear.getCarMake() >= 2021 && carManufactureYear.getCarMake() < 2025) {
            totalRepairmentCost *= 2;
        }

        switch (nameAndSurname) {
            case "Алексей Привольнов" -> OBJECTS_CREATOR.alexeyPrivolnovInvoice.setTotalCost(totalRepairmentCost);
            case "Сергей Власов" -> OBJECTS_CREATOR.sergeyVlasovInvoice.setTotalCost(totalRepairmentCost);
            case "Владимир Долгин" -> OBJECTS_CREATOR.vladimirDolginInvoice.setTotalCost(totalRepairmentCost);
            default -> System.out.println("Такого клиента не существует");
        }
    }

    // Method checks diagnostics result
    public static void checkDiagnosticsResult(
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
            default -> System.out.printf(
                    "%sТакого клиента не существует!%s\n", ANSI_RED, ANSI_RESET
            );
        }
    }

    // Method checks damages' severity
    public static void checkDamagesSeverity(
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
            default -> System.out.printf(
                    "%sТакого клиента не существует!%s\n", ANSI_RED, ANSI_RESET
            );
        }
    }

    // Method calculates total cost of repairment
    public static void repairmentCostCalculator(
            CarYears carManufactureYear, String diagnosticsResult,
            String damagesSeverity, int diagnosticsTime
    ) {
        checkCarManufactureYear(
                OBJECTS_CREATOR.bmwX6.getCarManufactureYear(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname()
        );

        checkDiagnosticsResult(
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsResult(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname(),
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
        );

        checkDamagesSeverity(
                OBJECTS_CREATOR.bmwX6Diagnostics.getDamagesSeverity(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname(),
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
        );

        System.out.println(ANSI_GREEN + "Общая стоимость ремонта автомобиля: " + ANSI_YELLOW +
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost() + ANSI_RESET
        );
        System.out.println();
    }
}
