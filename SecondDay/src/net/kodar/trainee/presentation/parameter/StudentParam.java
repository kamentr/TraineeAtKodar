package net.kodar.trainee.presentation.parameter;

public class StudentParam {

    private int ID;
    private String firstName;
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
