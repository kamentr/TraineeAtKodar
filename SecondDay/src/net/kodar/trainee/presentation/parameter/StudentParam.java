package net.kodar.trainee.presentation.parameter;

public class StudentParam {

    private int ID;
    private String firstName;
    private String lastName;
    private int identifier;


    public StudentParam() {

    }

    public StudentParam(int id, String firstName, String lastName) {
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

    public int getIdentifier() {
        return identifier;
    }

    private void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

}
