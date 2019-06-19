package net.kodar.trainee.data.entities;

public class Student {
    private int ID;
    private String firstName;
    private String lastName;

    public Student() {

    }

    public Student(int id, String firstName, String lastName) {
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


    @Override
    public String toString() {
        return  "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\''  +
                '}';
    }

}
