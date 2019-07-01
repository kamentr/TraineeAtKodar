package net.kodar.university.presentation.result;

import net.kodar.university.data.entities.Discipline;

import java.util.Objects;

public class DisciplineResult {

    private Integer id;
    private String disciplineName;

    public DisciplineResult(Integer id, String disciplineName) {
        this.setDisciplineName(disciplineName);
    }

    public DisciplineResult() {

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
        return id.equals(that.getId()) &&
                disciplineName.equals(that.getDisciplineName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplineName);
    }
}


