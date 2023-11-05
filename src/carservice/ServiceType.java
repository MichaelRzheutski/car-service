package carservice;

import java.util.Objects;

// ServiceRecord: Represents provided service, date and cost
public class ServiceType extends CarService {
    private String serviceType;
    private String serviceDate;
    private double serviceCost;

    public ServiceType(String serviceType, String serviceDate, double serviceCost) {
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.serviceCost = serviceCost;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
        ServiceType serviceType = (ServiceType) o;
        return Double.compare(serviceType.serviceCost, serviceCost) == 0
                && Objects.equals(this.serviceType, serviceType.serviceType)
                && Objects.equals(serviceDate, serviceType.serviceDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceType, serviceDate, serviceCost);
    }

    @Override
    public String toString() {
        return "ProvidedService{" +
                "serviceProvided='" + serviceType + '\'' +
                ", serviceDate='" + serviceDate + '\'' +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
