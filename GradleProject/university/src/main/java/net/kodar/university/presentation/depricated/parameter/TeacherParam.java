package net.kodar.university.presentation.depricated.parameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherParam {

    @Min(value = 0, message = "Id cannot be negative")
    private int id;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String firstName;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String lastName;

    public TeacherParam(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public TeacherParam() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
