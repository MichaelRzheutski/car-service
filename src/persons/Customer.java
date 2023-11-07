package persons;

import car.SparePart;
import carservice.Appointment;
import carservice.Invoice;
import carservice.ServiceType;

import java.util.Formatter;
import java.util.Locale;
import java.util.Objects;

import static helpers.ConsoleColors.*;

// Customer: Represents a whole information about customer
public final class Customer extends Person {
    private Appointment appointment;
    private String contactInformation;
    private String carName;
    private ServiceType serviceType;
    private Mechanic mechanic;
    private SparePart sparePart;
    private Invoice invoice;

    public Customer(
            Appointment appointment, String name, String surname,
            String contactInformation, String carName, ServiceType serviceType,
            Mechanic mechanic, SparePart sparePart, Invoice invoice) {
        super(name, surname);
        this.appointment = appointment;
        this.name = name;
        this.contactInformation = contactInformation;
        this.carName = carName;
        this.serviceType = serviceType;
        this.mechanic = mechanic;
        this.sparePart = sparePart;
        this.invoice = invoice;
        this.role = "Клиент";
    }

    @Override
    public String showPersonRole() {
        return role;
    }

    // Method shows whole info about customers
    public static void showCustomers(Customer[] customers) {

        for (Customer customer : customers) {
            System.out.println(
                    ANSI_GREEN + "Имя и фамилия клиента: " + ANSI_YELLOW
                            + customer.getName() + " " + customer.getSurname() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Роль: " + ANSI_YELLOW
                            + customer.getRole() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Телефон: " + ANSI_YELLOW
                            + customer.getContactInformation() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Дата поступления авто в обслуживание: " + ANSI_YELLOW
                            + customer.getAppointment().getDate() + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Марка авто: " + ANSI_YELLOW + customer.getCarName() + ANSI_RESET);
            System.out.println(
                    ANSI_GREEN + "Услуга: " + ANSI_YELLOW
                            + customer.getServiceRecord().getServiceType()
                            + ANSI_RESET
            );
            System.out.println(
                    ANSI_GREEN + "Дата оказания услуги: " + ANSI_YELLOW
                            + customer.getServiceRecord().getServiceDate()
                            + ANSI_RESET
            );
            Formatter serviceCostFormat = new Formatter(Locale.US).format(
                    ANSI_GREEN + "Стоимость услуги: " + ANSI_YELLOW + "%.2f$\n"
                            + ANSI_RESET, customer.getServiceRecord().getServiceCost());
            System.out.printf(serviceCostFormat.toString());
            System.out.println(
                    ANSI_GREEN + "Механик: " + ANSI_YELLOW + customer.getMechanic().getName() + " "
                            + customer.getMechanic().getSurname() + ANSI_GREEN + " | Квалификация: " + ANSI_YELLOW
                            + customer.getMechanic().getExpertise() + ANSI_GREEN + " | Доступность специалиста: "
                            + ANSI_YELLOW + customer.getMechanic().getAvailability() + ANSI_RESET
            );

            if (customer.getSparePart().isInStock().equals("да")) {
                System.out.println(
                        ANSI_GREEN + "Запчасть: " + ANSI_YELLOW
                                + customer.getSparePart().getSparePartType() + ANSI_GREEN
                                + " в наличии на складе" + ANSI_RESET

                );
            } else {
                System.out.println(
                        ANSI_GREEN + "Запчасть: " + ANSI_YELLOW
                                + customer.getSparePart().getSparePartType() + ANSI_GREEN
                                + " отсутствует на складе" + ANSI_RESET
                );
            }

            Formatter invoiceFormat = new Formatter(Locale.US).format(
                    ANSI_GREEN + "Счёт на сумму: " + ANSI_YELLOW + "%.2f$"  + ANSI_GREEN + " %s\n",
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

    public ServiceType getServiceRecord() {
        return serviceType;
    }

    public void setServiceRecord(ServiceType serviceType) {
        this.serviceType = serviceType;
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
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(appointment, customer.appointment)
                && Objects.equals(contactInformation, customer.contactInformation)
                && Objects.equals(carName, customer.carName)
                && Objects.equals(serviceType, customer.serviceType)
                && Objects.equals(mechanic, customer.mechanic)
                && Objects.equals(sparePart, customer.sparePart)
                && Objects.equals(invoice, customer.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(), appointment, contactInformation,
                carName, serviceType, mechanic, sparePart, invoice
        );
    }
}
