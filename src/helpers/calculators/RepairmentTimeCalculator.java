package helpers.calculators;

import car.SparePart;
import helpers.ObjectsCreator;
import persons.Mechanic;

import java.util.Scanner;

import static helpers.ConsoleColors.*;

public final class RepairmentTimeCalculator {
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
                            OBJECTS_CREATOR.bmwX6Diagnostics.getDiagnosticsTime(),
                            OBJECTS_CREATOR.bmwX6.getSpareParts(),
                            OBJECTS_CREATOR.mechanics
                    );
                    break;
                case 2:
                    repairmentTimeCalculator(
                            OBJECTS_CREATOR.toyotaLandCruiserDiagnostics.getDiagnosticsTime(),
                            OBJECTS_CREATOR.toyotaLandCruiser.getSpareParts(),
                            OBJECTS_CREATOR.mechanics
                    );
                    break;
                case 3:
                    repairmentTimeCalculator(
                            OBJECTS_CREATOR.mercedesBenzDiagnostics.getDiagnosticsTime(),
                            OBJECTS_CREATOR.mercedesBenz.getSpareParts(),
                            OBJECTS_CREATOR.mechanics
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

    // Method calculates total cost of repairment including diagnostics result,
    // damages severity and term of spare parts delivery
    public static void repairmentTimeCalculator(
            int diagnosticsTime, SparePart[] spareParts, Mechanic[] mechanics
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

        int totalRepairmentTime = 0;
        int sparePartsDeliveryTime;
        for (SparePart sparePart : spareParts) {
            sparePartsDeliveryTime = sparePart.getDeliveryDays();
            totalRepairmentTime = diagnosticsTime + sparePartsDeliveryTime;
        }

        String mechanicExpertise;
        for (Mechanic mechanic : mechanics) {
            mechanicExpertise = mechanic.getExpertise();

            if (mechanicExpertise.equals("мастер")) {
                totalRepairmentTime += 1;
                break;
            }
            if (mechanicExpertise.equals("специалист")) {
                totalRepairmentTime += 2;
                break;
            }
            if (mechanicExpertise.equals("стажёр")) {
                totalRepairmentTime += 3;
                break;
            }
        }

        System.out.println(ANSI_GREEN + "Общее время ремонта автомобиля в днях: "
                + ANSI_YELLOW + totalRepairmentTime + ANSI_RESET
        );
        System.out.println();
    }
}
