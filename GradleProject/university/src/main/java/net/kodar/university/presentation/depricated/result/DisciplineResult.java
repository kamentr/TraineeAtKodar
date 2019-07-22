package net.kodar.university.presentation.depricated.result;

import net.kodar.university.data.entities.Discipline;

import java.util.Objects;

public class DisciplineResult {

    private Integer id;
    private String name;

    public DisciplineResult(String name) {
        this.setName(name);
    }

    public DisciplineResult() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Discipline{ " + name +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;
        Discipline that = (Discipline) o;
        return id.equals(that.getId()) &&
                name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}


