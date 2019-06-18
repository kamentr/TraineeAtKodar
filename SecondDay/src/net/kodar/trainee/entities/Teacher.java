package net.kodar.trainee.entities;

import java.util.List;

public class Teacher {

    private int id;
    private String fName;
    private String lName;
    private List<Student> students;

    public Teacher(String fName, String lName, List<Student> students) {
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

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "net.kodar.trainee.entities.Teacher{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", students=" + students +
                '}';
    }
}
