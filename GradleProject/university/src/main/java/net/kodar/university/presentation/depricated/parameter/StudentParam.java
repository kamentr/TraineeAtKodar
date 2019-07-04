package net.kodar.university.presentation.depricated.parameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentParam {

    @NotNull(message = "Id cannot be null")
    @Min(value = 0, message = "Id cannot be negative")
    private int ID;
    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String firstName;
    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String lastName;

    public StudentParam() {

    }

    public StudentParam(int id, String firstName, String lastName) {
        setID(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    private void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
