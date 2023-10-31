package carservice;

// CarService: Provides a name of the car service
public class CarService {
    private String carServiceName;

    public CarService(){};

    public CarService(String carServiceName){
        this.carServiceName = carServiceName;
    }

    public String getCarServiceName() {
        return carServiceName;
    }

    public void setCarServiceName(String carServiceName) {
        this.carServiceName = carServiceName;
    }

}
