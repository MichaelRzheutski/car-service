import car.Car;
import car.SparePart;
import car.SparePartsShop;
import carservice.*;
import persons.Customer;
import persons.Mechanic;

// Main: Runner class
public class Main {
    public static void main(String[] args) {
        // Create car service
        CarService carService = new CarService("Добро пожаловать в Автосервис '4 колеса!'");

        // Create cars
        Car bmwX6 = new Car("BMW", "X6", "2023", 1000);
        Car toyotaLandCruiser = new Car("Toyota", "Land Cruiser", "2023", 500);
        Car mercedesBenz = new Car("Mercedes", "Benz", "2023", 300);

        // Create services for cars
        ServiceType oilChange = new ServiceType("Замена моторного масла");
        ServiceType tireRotation = new ServiceType("Замена шин");
        ServiceType brakeInspection = new ServiceType("Диагностика тормозов");

        // Create service records for customers
        ServiceRecord alexeyPrivolnovService = new ServiceRecord(
                oilChange, "5 Сентября 2023", 50.00
        );
        ServiceRecord sergeyVlasovService = new ServiceRecord(
                tireRotation, "20 Сентября 2023", 100.00
        );
        ServiceRecord vladimirDolginService = new ServiceRecord(
                brakeInspection, "5 Октября 2023", 25.00
        );

        // Create mechanics
        Mechanic vladlenPoddubitsky = new Mechanic(
                "Владлен", "Поддубицкий", "высшая", "Доступен"
        );
        Mechanic vyacheslavMarshal = new Mechanic(
                "Вячеслав", "Маршал", "средняя", "Занят"
        );
        Mechanic evgenyBely = new Mechanic(
                "Евгений", "Белый", "высшая", "занят"
        );

        // Create spare parts
        SparePart oilSpare = new SparePart("Масло", true);
        SparePart tiresSpare = new SparePart("Комплект шин", false);
        SparePart brakesSpare = new SparePart("Комплект тормозов", true);
        SparePart[] spareParts = {oilSpare, tiresSpare, brakesSpare};

        // Supply spare parts to the shop
        SparePartsShop oil = new SparePartsShop(oilSpare, 50.00);
        SparePartsShop tires = new SparePartsShop(tiresSpare, 200.00);
        SparePartsShop brakes = new SparePartsShop(brakesSpare, 100.00);
        SparePartsShop[] sparePartsInShop = {oil, tires, brakes};

        // Create appointments
        Appointment alexeyPrivolnovAppointment = new Appointment("10 Августа 2023");
        Appointment sergeyVlasovAppointment = new Appointment("5 Сентября 2023");
        Appointment vladimirDolginAppointment = new Appointment("25 Сентября 2023");

        // Create invoices
        Invoice alexeyPrivolnovInvoice = new Invoice(50.00, "оплачен");
        Invoice sergeyVlasovInvoice = new Invoice(100.00, "оплачен");
        Invoice vladimirDolginInvoice = new Invoice(25.00, "оплачен");

        // Create customers
        Customer alexeyPrivolnov = new Customer(
                alexeyPrivolnovAppointment,
                "Алексей",
                "Привольнов",
                "+735253458756",
                Car.createCarFullName(bmwX6.getMake(), bmwX6.getModel()),
                alexeyPrivolnovService,
                vladlenPoddubitsky,
                oilSpare,
                alexeyPrivolnovInvoice
        );

        Customer sergeyVlasov = new Customer(
                sergeyVlasovAppointment,
                "Сергей",
                "Власов",
                "+735293879581",
                Car.createCarFullName(toyotaLandCruiser.getMake(), toyotaLandCruiser.getModel()),
                sergeyVlasovService,
                vyacheslavMarshal,
                tiresSpare,
                sergeyVlasovInvoice
        );

        Customer vladimirDolgin = new Customer(
                vladimirDolginAppointment,
                "Владимир",
                "Долгин",
                "+735337847623",
                Car.createCarFullName(mercedesBenz.getMake(), mercedesBenz.getModel()),
                vladimirDolginService,
                evgenyBely,
                brakesSpare,
                vladimirDolginInvoice
        );
        Customer[] customers = {alexeyPrivolnov, sergeyVlasov, vladimirDolgin};

        // Show info about customers
        Customer.showCustomers(carService, customers);

        //Show spare parts in shop
        SparePartsShop.showSparePartsInStore(sparePartsInShop);
    }
}
