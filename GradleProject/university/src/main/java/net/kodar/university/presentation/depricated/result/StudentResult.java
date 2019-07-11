package net.kodar.university.presentation.depricated.result;

public class StudentResult {

    private Integer id;
    private String firstName;
    private String lastName;

    public StudentResult() {}

    public StudentResult(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

}
