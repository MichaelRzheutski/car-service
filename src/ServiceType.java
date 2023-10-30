// ServiceType: Represents service type and makes of parts it using in process.
public class ServiceType {
    private String serviceType;
    private String makeOfOil;
    private String makeOfTires;
    private String makeOfBrakes;

    public ServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMakeOfOil() {
        return makeOfOil;
    }

    public void setMakeOfOil(String makeOfOil) {
        this.makeOfOil = makeOfOil;
    }

    public String getMakeOfTires() {
        return makeOfTires;
    }

    public void setMakeOfTires(String makeOfTires) {
        this.makeOfTires = makeOfTires;
    }

    public String getMakeOfBrakes() {
        return makeOfBrakes;
    }

    public void setMakeOfBrakes(String makeOfBrakes) {
        this.makeOfBrakes = makeOfBrakes;
    }
}
