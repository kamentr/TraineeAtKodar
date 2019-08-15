package net.kodar.university.presentation.depricated.result;

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

}


