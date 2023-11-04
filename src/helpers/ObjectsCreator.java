package helpers;

import car.Car;
import car.CarDiagnostics;
import car.SparePart;
import carservice.*;
import persons.Customer;
import persons.Mechanic;

import static helpers.cars.CarYears.*;
import static helpers.cars.Cars.*;
import static helpers.spareparts.SparePartMakes.*;
import static helpers.spareparts.SparePartTypes.*;

public class ObjectsCreator {
    private final boolean IS_IN_STOCK = true;
    private final boolean IS_NOT_IN_STOCK = false;

    public ObjectsCreator() {
    }

    // Create spare parts
    public SparePart oilSpare = new SparePart(
            ENGINE_OIL,
            ENGINE_OIL_MAKE,
            IS_IN_STOCK
    );
    public SparePart tiresSpare = new SparePart(
            TIRE_SET,
            TIRE_SET_MAKE,
            IS_NOT_IN_STOCK
    );
    public SparePart brakesSpare = new SparePart(
            BRAKE_SET,
            BRAKE_SET_MAKE,
            IS_IN_STOCK
    );

    // Create cars
    public Car bmwX6 = new Car(
            BMW_X6,
            YEAR_2023,
            1000,
            new SparePart[]{oilSpare, tiresSpare, brakesSpare}
    );
    public Car toyotaLandCruiser = new Car(
            TOYOTA_LAND_CRUISER,
            YEAR_2020,
            20000,
            new SparePart[]{oilSpare, tiresSpare}
    );
    public Car mercedesBenz = new Car(
            MERCEDES_BENZ,
            YEAR_2015,
            500000,
            new SparePart[]{oilSpare}
    );
    public Car[] cars = {bmwX6, toyotaLandCruiser, mercedesBenz};

    // Create services for cars
    public ServiceType oilChange = new ServiceType("Замена моторного масла");
    public ServiceType tireRotation = new ServiceType("Замена шин");
    public ServiceType brakeInspection = new ServiceType("Диагностика тормозов");

    // Create service records for customers
    public ProvidedService alexeyPrivolnovService = new ProvidedService(
            oilChange, "5 Сентября 2023", 50.00
    );
    public ProvidedService sergeyVlasovService = new ProvidedService(
            tireRotation, "20 Сентября 2023", 100.00
    );
    public ProvidedService vladimirDolginService = new ProvidedService(
            brakeInspection, "5 Октября 2023", 25.00
    );

    // Create mechanics
    public Mechanic vladlenPoddubitsky = new Mechanic(
            "Владлен", "Поддубицкий", "высшая", "Доступен"
    );
    public Mechanic vyacheslavMarshal = new Mechanic(
            "Вячеслав", "Маршал", "средняя", "Занят"
    );
    public Mechanic evgenyBely = new Mechanic(
            "Евгений", "Белый", "высшая", "Занят"
    );

    // Supply spare parts to the shop
    public SparePartsShop oil = new SparePartsShop(oilSpare, 50.00);
    public SparePartsShop tires = new SparePartsShop(tiresSpare, 200.00);
    public SparePartsShop brakes = new SparePartsShop(brakesSpare, 100.00);
    public SparePartsShop[] sparePartsInShop = {oil, tires, brakes};

    // Create appointments
    public Appointment alexeyPrivolnovAppointment = new Appointment("10 Августа 2023");
    public Appointment sergeyVlasovAppointment = new Appointment("5 Сентября 2023");
    public Appointment vladimirDolginAppointment = new Appointment("25 Сентября 2023");

    // Create invoices
    public Invoice alexeyPrivolnovInvoice = new Invoice(300.00, "оплачен");
    public Invoice sergeyVlasovInvoice = new Invoice(100.00, "оплачен");
    public Invoice vladimirDolginInvoice = new Invoice(150.00, "оплачен");

    // Car diagnostics
    public CarDiagnostics bmwX6Diagnostics = new CarDiagnostics(
            bmwX6,
            "Требуется замена моторного масла",
            "Повреждения отсутствуют",
            1
    );
    public CarDiagnostics toyotaLandCruiserDiagnostics = new CarDiagnostics(
            toyotaLandCruiser,
            "Требуется замена шин",
            "Лёгкие повреждения",
            3
    );
    public CarDiagnostics mercedesBenzDiagnostics = new CarDiagnostics(
            mercedesBenz,
            "Требуется замена тормозных колодок",
            "Серьёзные повреждения",
            4
    );

    // Create customers
    public Customer alexeyPrivolnov = new Customer(
            alexeyPrivolnovAppointment,
            "Алексей",
            "Привольнов",
            "+735253458756",
            bmwX6.getCarMake().toString(),
            alexeyPrivolnovService,
            vladlenPoddubitsky,
            oilSpare,
            alexeyPrivolnovInvoice
    );

    public Customer sergeyVlasov = new Customer(
            sergeyVlasovAppointment,
            "Сергей",
            "Власов",
            "+735293879581",
            toyotaLandCruiser.getCarMake().toString(),
            sergeyVlasovService,
            vyacheslavMarshal,
            tiresSpare,
            sergeyVlasovInvoice
    );

    public Customer vladimirDolgin = new Customer(
            vladimirDolginAppointment,
            "Владимир",
            "Долгин",
            "+735337847623",
            mercedesBenz.getCarMake().toString(),
            vladimirDolginService,
            evgenyBely,
            brakesSpare,
            vladimirDolginInvoice
    );
    public Customer[] customers = {alexeyPrivolnov, sergeyVlasov, vladimirDolgin};
}
