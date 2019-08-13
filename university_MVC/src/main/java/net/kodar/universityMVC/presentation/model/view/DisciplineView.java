package net.kodar.universityMVC.presentation.model.view;


import java.util.Objects;

public class DisciplineView {

    private Integer id;
    private String name;

    public DisciplineView(String name) {
        this.setName(name);
    }

    public DisciplineView() {}

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


