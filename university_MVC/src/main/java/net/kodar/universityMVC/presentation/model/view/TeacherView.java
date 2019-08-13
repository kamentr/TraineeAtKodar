package net.kodar.universityMVC.presentation.model.view;

public class TeacherView {
    private int id;
    private String firstName;
    private String lastName;


    public TeacherView(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public TeacherView(int id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public TeacherView() {

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
                "id= " + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
