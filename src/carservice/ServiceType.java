package carservice;

import java.util.Objects;

// ServiceType: Represents service type and makes of parts it using in process.
public class ServiceType extends CarService {
    private String serviceType;

    public ServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceType that = (ServiceType) o;
        return Objects.equals(serviceType, that.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceType);
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "serviceType='" + serviceType + '\'' +
                '}';
    }
}
