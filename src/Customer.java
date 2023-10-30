import java.util.Formatter;
import java.util.Locale;

// Customer: Represents a whole information about customer
public class Customer extends Person {
    private Appointment appointment;
    private String contactInformation;
    private String carName;
    private ServiceRecord serviceRecord;
    private Mechanic mechanic;
    private SparePart sparePart;
    private Invoice invoice;

    public Customer(
            Appointment appointment, String name, String surname,
            String contactInformation, String carName, ServiceRecord serviceRecord,
            Mechanic mechanic, SparePart sparePart, Invoice invoice) {
        super(name, surname);
        this.appointment = appointment;
        this.name = name;
        this.contactInformation = contactInformation;
        this.carName = carName;
        this.serviceRecord = serviceRecord;
        this.mechanic = mechanic;
        this.sparePart = sparePart;
        this.invoice = invoice;
    }

    // Method shows whole info about customers
    public static void showCustomers(CarService carService, Customer[] customers) {
        System.out.println(carService.getCarServiceName() + "\n");

        for (Customer customer : customers) {
            System.out.printf("Имя и фамилия клиента: %s %s\n", customer.getName(), customer.getSurname());
            System.out.println("Телефон: " + customer.getContactInformation());
            System.out.printf("Дата поступления авто в обслуживание: %s\n", customer.getAppointment().getDate());
            System.out.println("Марка авто: " + customer.getCarName());
            System.out.println("Услуга: " + customer.getServiceRecord().getServiceProvided().getServiceType());
            System.out.println("Дата оказания услуги: " + customer.getServiceRecord().getDate());
            Formatter serviceCostFormat = new Formatter(Locale.US).format(
                    "Стоимость услуги: %.2f руб\n",
                    customer.getServiceRecord().getCost());
            System.out.printf(serviceCostFormat.toString());
            System.out.printf("Механик: %s %s | Квалификация: %s | Доступность специалиста: %s\n",
                    customer.getMechanic().getName(),
                    customer.getMechanic().getSurname(),
                    customer.getMechanic().getExpertise(),
                    customer.getMechanic().getAvailability()
            );

            if (customer.getSparePart().isInStock()) {
                System.out.printf(
                        "Запчасть: '%s' в наличии на складе\n",
                        customer.getSparePart().getSparePartName()
                );
            } else {
                System.out.printf(
                        "Запчасть: '%s' отсутствует на складе\n",
                        customer.getSparePart().getSparePartName()
                );
            }

            Formatter invoiceFormat = new Formatter(Locale.US).format(
                    "Счёт на сумму %.2f руб %s\n",
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

    public ServiceRecord getServiceRecord() {
        return serviceRecord;
    }

    public void setServiceRecord(ServiceRecord serviceRecord) {
        this.serviceRecord = serviceRecord;
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
}
