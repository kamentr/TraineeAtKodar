package net.kodar.universityUI.presentation.model.param;

import net.kodar.universityUI.data.entities.Student;
import net.kodar.universityUI.data.entities.Teacher;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StudentTeacherParam {

    @NotNull(message = "student id cannot be null")
    @Min(value = 0, message = "Id cannot be negative")
    private Student student;

    @NotNull(message = "Id cannot be null")
    @Min(value = 0, message = "Id cannot be negative")
    private Teacher teacher;

    @Min(value = 0, message = "Id cannot be negative")
    private Integer id;

    public StudentTeacherParam(Student student, Teacher teacher, Integer id) {
        this.student = student;
        this.teacher = teacher;
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StudentTeacherParam() {
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

}
