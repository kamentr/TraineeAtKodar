package net.kodar.university.presentation.depricated.parameter;

public class TeacherParam {
    private int id;
    private String fName;
    private String lName;

    public TeacherParam(int id, String fName, String lName) {
        setId(id);
        setfName(fName);
        setlName(lName);
    }

    public TeacherParam() {

    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setfName(String fName) {
        this.fName = fName;
    }

    private void setlName(String lName) {
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
