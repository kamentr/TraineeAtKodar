package net.kodar.university.presentation.depricated.parameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentParam {

    @Min(value = 0, message = "Id cannot be negative")
    private Integer id;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String firstName;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String lastName;

    public StudentParam() {

    }

    public StudentParam(Integer id, String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
    }

    public StudentParam(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }


    private void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
