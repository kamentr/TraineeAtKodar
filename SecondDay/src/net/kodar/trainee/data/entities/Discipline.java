package net.kodar.trainee.data.entities;

import java.util.Objects;

public class Discipline {

    private Integer id;
    private String disciplineName;

    public Discipline(Integer id, String disciplineName) {

        this.disciplineName = disciplineName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public String toString() {
        return "Discipline{ " + disciplineName +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;
        Discipline that = (Discipline) o;
        return id.equals(that.id) &&
                disciplineName.equals(that.disciplineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplineName);
    }
}
