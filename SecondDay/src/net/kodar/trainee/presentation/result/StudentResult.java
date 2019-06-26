package net.kodar.trainee.presentation.result;

import java.util.UUID;

public class StudentResult {
    private int ID;
    private String firstName;
    private String lastName;
    private UUID identifier;


    public StudentResult() {

    }

    public StudentResult(int id, String firstName, String lastName) {
        setID(id);
        setFirstName(firstName);
        setLastName(lastName);
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

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }
}
