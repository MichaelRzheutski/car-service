package persons;

import java.util.Objects;

// Mechanic: Represents a mechanic with his expertise and availability
public class Mechanic extends Person {
    private String expertise;
    private String availability;

    public Mechanic(String name, String surname, String expertise, String availability) {
        super(name, surname);
        this.name = name;
        this.surname = surname;
        this.expertise = expertise;
        this.availability = availability;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(expertise, mechanic.expertise)
                && Objects.equals(availability, mechanic.availability
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(expertise, availability);
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "expertise='" + expertise + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
