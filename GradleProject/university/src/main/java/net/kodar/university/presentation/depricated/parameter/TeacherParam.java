package net.kodar.university.presentation.depricated.parameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherParam {

    @NotNull(message = "Id cannot be null")
    @Min(value = 0, message = "Id cannot be negative")
    private int id;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String fName;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 30")
    private String lName;

    public TeacherParam(int id, String fName, String lName) {
        setId(id);
        setfName(fName);
        setlName(lName);
    }

    public TeacherParam() {

    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setfName(String fName) {
        this.fName = fName;
    }

    private void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public String toString() {
        return "{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
