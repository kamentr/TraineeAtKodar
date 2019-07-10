package net.kodar.university.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int ID;
    private String firstName;
    private String lastName;
    private UUID identifier;

    public Student() {
        this.setIdentifier(UUID.randomUUID());
    }

    public Student(int id, String firstName, String lastName) {
        setID(id);
        setFirstName(firstName);
        setLastName(lastName);
        this.setIdentifier(UUID.randomUUID());
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
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

    public UUID getIdentifier() {
        return identifier;
    }

    private void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
