package carservice;

import java.util.Objects;

// ServiceRecord: Represents provided service, date and cost
public class ProvidedService extends CarService {
    private ServiceType serviceProvided;
    private String serviceDate;
    private double serviceCost;

    public ProvidedService(ServiceType serviceProvided, String serviceDate, double serviceCost) {
        this.serviceProvided = serviceProvided;
        this.serviceDate = serviceDate;
        this.serviceCost = serviceCost;
    }

    public ServiceType getServiceProvided() {
        return serviceProvided;
    }

    public void setServiceProvided(ServiceType serviceProvided) {
        this.serviceProvided = serviceProvided;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvidedService providedService = (ProvidedService) o;
        return Double.compare(providedService.serviceCost, serviceCost) == 0
                && Objects.equals(serviceProvided, providedService.serviceProvided)
                && Objects.equals(serviceDate, providedService.serviceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceProvided, serviceDate, serviceCost);
    }
}
