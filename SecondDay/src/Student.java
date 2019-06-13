public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private String number;

    public Student() {

    }

    public Student(int ID, String firstName, String lastName, String number) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
