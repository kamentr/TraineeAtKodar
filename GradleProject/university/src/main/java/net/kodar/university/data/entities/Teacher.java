package net.kodar.university.data.entities;

import java.util.UUID;

public class Teacher {

    private int id;
    private String fName;
    private String lName;
    private UUID identifier;


    public Teacher(int id, String fName, String lName) {
        this.setId(id);
        this.setfName(fName);
        this.setlName(lName);
        this.setIdentifier(UUID.randomUUID());
    }

    public Teacher() {
        this.setIdentifier(UUID.randomUUID());
    }

    public UUID getIdentifier() {
        return identifier;
    }

    private void setIdentifier(UUID identifier) {
        this.identifier = identifier;
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
