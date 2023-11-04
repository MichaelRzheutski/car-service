package persons;

import car.SparePart;
import carservice.Appointment;
import carservice.Invoice;
import carservice.ProvidedService;

import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;

import static helpers.ConsoleColors.ANSI_RESET;
import static helpers.ConsoleColors.ANSI_YELLOW;

// Customer: Represents a whole information about customer
public class Customer extends Person {
    private Appointment appointment;
    private String contactInformation;
    private String carName;
    private ProvidedService providedService;
    private Mechanic mechanic;
    private SparePart sparePart;
    private Invoice invoice;

    public Customer(
            Appointment appointment, String name, String surname,
            String contactInformation, String carName, ProvidedService providedService,
            Mechanic mechanic, SparePart sparePart, Invoice invoice) {
        super(name, surname);
        this.appointment = appointment;
        this.name = name;
        this.contactInformation = contactInformation;
        this.carName = carName;
        this.providedService = providedService;
        this.mechanic = mechanic;
        this.sparePart = sparePart;
        this.invoice = invoice;
    }

    // Method shows whole info about customers
    public static void showCustomers(Customer[] customers) {

        for (Customer customer : customers) {
            System.out.printf(
                    ANSI_YELLOW + "Имя и фамилия клиента: %s %s\n",
                    customer.getName(),
                    customer.getSurname() + ANSI_RESET
            );
            System.out.println(
                    ANSI_YELLOW + "Телефон: "
                            + customer.getContactInformation() + ANSI_RESET
            );
            System.out.printf(
                    ANSI_YELLOW + "Дата поступления авто в обслуживание: %s\n",
                    customer.getAppointment().getDate() + ANSI_RESET
            );
            System.out.println(
                    ANSI_YELLOW + "Марка авто: " + customer.getCarName() + ANSI_RESET);
            System.out.println(
                    ANSI_YELLOW + "Услуга: "
                            + customer.getServiceRecord().getServiceProvided().getServiceType()
                            + ANSI_RESET
            );
            System.out.println(
                    ANSI_YELLOW + "Дата оказания услуги: "
                            + customer.getServiceRecord().getServiceDate()
                            + ANSI_RESET
            );
            Formatter serviceCostFormat = new Formatter(Locale.US).format(
                    ANSI_YELLOW + "Стоимость услуги: %.2f руб\n"
                            + ANSI_RESET, customer.getServiceRecord().getServiceCost());
            System.out.printf(serviceCostFormat.toString());
            System.out.printf(
                    ANSI_YELLOW
                            + "Механик: %s %s | Квалификация: %s | Доступность специалиста: %s\n"
                            + ANSI_RESET,
                    customer.getMechanic().getName(),
                    customer.getMechanic().getSurname(),
                    customer.getMechanic().getExpertise(),
                    customer.getMechanic().getAvailability()
            );

            if (customer.getSparePart().isInStock()) {
                System.out.printf(
                        ANSI_YELLOW + "Запчасть: '%s' в наличии на складе\n" + ANSI_RESET,
                        customer.getSparePart().getSparePartType()
                );
            } else {
                System.out.printf(
                        ANSI_YELLOW + "Запчасть: '%s' отсутствует на складе\n" + ANSI_RESET,
                        customer.getSparePart().getSparePartType()
                );
            }

            Formatter invoiceFormat = new Formatter(Locale.US).format(
                    ANSI_YELLOW + "Счёт на сумму %.2f руб %s\n" + ANSI_RESET,
                    customer.getInvoice().getTotalCost(),
                    customer.getInvoice().getPaymentStatus());
            System.out.printf(invoiceFormat.toString());

            System.out.println();
        }
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public ProvidedService getServiceRecord() {
        return providedService;
    }

    public void setServiceRecord(ProvidedService providedService) {
        this.providedService = providedService;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(appointment, customer.appointment)
                && Objects.equals(contactInformation, customer.contactInformation)
                && Objects.equals(carName, customer.carName)
                && Objects.equals(providedService, customer.providedService)
                && Objects.equals(mechanic, customer.mechanic)
                && Objects.equals(sparePart, customer.sparePart)
                && Objects.equals(invoice, customer.invoice
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                appointment, contactInformation, carName, providedService,
                mechanic, sparePart, invoice
        );
    }
}
