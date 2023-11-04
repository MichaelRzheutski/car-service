package car;

import java.util.Objects;

import static helpers.ConsoleColors.*;
import static helpers.ConsoleColors.ANSI_GREEN;

public class CarDiagnostics extends Car {
    private Car carForDiagnostics;
    private String diagnosticsResult;
    private String damagesSeverity;
    private int diagnosticsTime;

    public CarDiagnostics(
            Car carForDiagnostics, String diagnosticsResult,
            String damagesSeverity, int diagnosticsTime) {
        this.carForDiagnostics = carForDiagnostics;
        this.diagnosticsResult = diagnosticsResult;
        this.damagesSeverity = damagesSeverity;
        this.diagnosticsTime = diagnosticsTime;
    }

    public static void checkCar(CarDiagnostics carDiagnostics) {
        System.out.println(
                ANSI_GREEN + "Марка авто: " + ANSI_YELLOW +
                        carDiagnostics.getCarForDiagnostics().getCarMake() + ANSI_RESET
        );
        System.out.println(
                ANSI_GREEN + "Год выпуска: " + ANSI_YELLOW +
                        carDiagnostics.getCarForDiagnostics().getCarManufactureYear() + ANSI_RESET
        );
        System.out.println(
                ANSI_GREEN + "Пробег: " + ANSI_YELLOW +
                        carDiagnostics.getCarForDiagnostics().getMileage() + ANSI_RESET
        );
        System.out.println(
                ANSI_GREEN + "Результат диагностики: " + ANSI_YELLOW +
                        carDiagnostics.getDiagnosticsResult() + ANSI_RESET
        );
        System.out.println(
                ANSI_GREEN + "Степень повреждений: " + ANSI_YELLOW +
                        carDiagnostics.getDamagesSeverity() + ANSI_RESET
        );
        System.out.println(
                ANSI_GREEN + "Диагностика проводилась дней: " + ANSI_YELLOW +
                        carDiagnostics.getDiagnosticsTime() + ANSI_RESET
        );
        System.out.println();
    }

    public Car getCarForDiagnostics() {
        return carForDiagnostics;
    }

    public void setCarForDiagnostics(Car carForDiagnostics) {
        this.carForDiagnostics = carForDiagnostics;
    }

    public String getDiagnosticsResult() {
        return diagnosticsResult;
    }

    public void setDiagnosticsResult(String diagnosticsResult) {
        this.diagnosticsResult = diagnosticsResult;
    }

    public String getDamagesSeverity() {
        return damagesSeverity;
    }

    public void setDamagesSeverity(String damagesSeverity) {
        this.damagesSeverity = damagesSeverity;
    }

    public int getDiagnosticsTime() {
        return diagnosticsTime;
    }

    public void setDiagnosticsTime(int diagnosticsTime) {
        this.diagnosticsTime = diagnosticsTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDiagnostics carDiagnostics = (CarDiagnostics) o;
        return diagnosticsTime == carDiagnostics.diagnosticsTime
                && Objects.equals(carForDiagnostics, carDiagnostics.carForDiagnostics)
                && Objects.equals(diagnosticsResult, carDiagnostics.diagnosticsResult)
                && Objects.equals(damagesSeverity, carDiagnostics.damagesSeverity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                carForDiagnostics, diagnosticsResult,
                damagesSeverity, diagnosticsTime
        );
    }

    @Override
    public String toString() {
        return "CarDiagnostics{" +
                "carForDiagnostics=" + carForDiagnostics +
                ", diagnosticsResult='" + diagnosticsResult + '\'' +
                ", damagesSeverity='" + damagesSeverity + '\'' +
                ", diagnosticsTime=" + diagnosticsTime +
                '}';
    }
}
