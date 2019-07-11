package net.kodar.university.presentation.depricated.parameter;

import net.kodar.university.data.entities.Discipline;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class DisciplineParam {

    @Min(value = 0, message = "Id cannot be negative")
    private Integer id;

    @NotNull
    @Size(min=2, max=20, message = "Name size should be between 2 and 20")
    private String name;

    public DisciplineParam(String name) {
        this.setName(name);
    }

    public DisciplineParam() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
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
