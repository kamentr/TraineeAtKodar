package net.kodar.university.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private UUID identifier;


    public Teacher(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIdentifier(UUID.randomUUID());
    }

    public Teacher() {
        this.setIdentifier(UUID.randomUUID());
    }

    public UUID getIdentifier() {
        return identifier;
    }

    private void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return identifier.equals(teacher.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
