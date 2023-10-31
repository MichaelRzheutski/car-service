package carservice;

// ServiceRecord: Represents provided service, date and cost
public class ServiceRecord {
    private ServiceType serviceProvided;
    private String date;
    private double cost;

    public ServiceRecord(ServiceType serviceProvided, String date, double cost) {
        this.serviceProvided = serviceProvided;
        this.date = date;
        this.cost = cost;
    }

    public ServiceType getServiceProvided() {
        return serviceProvided;
    }

    public void setServiceProvided(ServiceType serviceProvided) {
        this.serviceProvided = serviceProvided;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
