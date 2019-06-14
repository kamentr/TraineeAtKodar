import java.util.ArrayList;

public class Teacher {

    private String fName;
    private String lName;

    private ArrayList<Student> students;

    public Teacher(String fName, String lName, ArrayList<Student> students) {
        this.fName = fName;
        this.lName = lName;
        this.students = students;
    }

    public Teacher(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        students = new ArrayList<>();
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
