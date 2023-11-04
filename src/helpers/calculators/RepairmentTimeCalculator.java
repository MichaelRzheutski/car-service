package helpers.calculators;

import helpers.ObjectsCreator;

import java.util.Scanner;

import static helpers.ConsoleColors.*;

public class RepairmentTimeCalculator {
    private static final ObjectsCreator OBJECTS_CREATOR = new ObjectsCreator();

    // Calculate car repairment time
    public static void calculateRepairmentTime(
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
                case 0:
                    exit = true;
                    break;
                case 1:
                    repairmentTimeCalculator(
                            OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
                    );
                    break;
                case 2:
                    repairmentTimeCalculator(
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDiagnosticsTime()
                    );
                    break;
                case 3:
                    repairmentTimeCalculator(
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getDiagnosticsTime()
                    );
                    break;
                default:
                    System.out.println(
                            ANSI_RED + "Неверная операция, попробуйте ещё раз!" + ANSI_RESET + "\n"
                    );
                    break;
            }
            break;
        }
    }

    // Method calculates total cost of repairment
    public static void repairmentTimeCalculator(
            int diagnosticsTime
    ) {
        RepairmentCostCalculator.checkDiagnosticsResult(
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsResult(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname(),
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
        );

        RepairmentCostCalculator.checkDamagesSeverity(
                OBJECTS_CREATOR.bmwX6Diagnostics.getDamagesSeverity(),
                OBJECTS_CREATOR.alexeyPrivolnovInvoice.getTotalCost(),
                OBJECTS_CREATOR.alexeyPrivolnov.getName(),
                OBJECTS_CREATOR.alexeyPrivolnov.getSurname(),
                OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime()
        );

        System.out.println(ANSI_YELLOW + "Общее время ремонта автомобиля в днях: " +
                diagnosticsTime + ANSI_RESET
        );
        System.out.println();
    }
}
