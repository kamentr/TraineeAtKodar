package net.kodar.trainee.data.entities;

import java.util.List;

public class Teacher {

    private int id;
    private String fName;
    private String lName;


    public Teacher(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

    }

    public Teacher(String fName, String lName, int id) {
        setId(id);
        setfName(fName);
        setlName(lName);
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

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public String toString() {
        return "{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
