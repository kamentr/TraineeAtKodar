package TeacherPackage;

import StudentPackage.Student;

import java.util.ArrayList;

public class Teacher {

    private int id;
    private String fName;
    private String lName;
    private ArrayList<Student> students;

    public Teacher(String fName, String lName, ArrayList<Student> students) {
        this.fName = fName;
        this.lName = lName;
        this.students = students;
    }

    public Teacher(String fName, String lName, int id) {
        setId(id);
        setfName(fName);
        setlName(lName);
        setStudents(students);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TeacherPackage.Teacher{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", students=" + students +
                '}';
    }
}
