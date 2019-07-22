package net.kodar.university.presentation.depricated.result;

public class TeacherResult {
    private int id;
    private String firstName;
    private String lastName;


    public TeacherResult(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public TeacherResult(int id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public TeacherResult() {

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
