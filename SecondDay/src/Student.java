public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private String facNumber;

    public Student() {

    }

    public Student(int id, String firstName, String lastName, String facNumber) {
        setID(id);
        setFirstName(firstName);
        setLastName(lastName);
        setfacNumber(facNumber);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setfacNumber(String facNumber) {
        this.facNumber = facNumber;
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

    public String getfacNumber() {
        return facNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", facNumber='" + facNumber + '\'' +
                '}';
    }
}
