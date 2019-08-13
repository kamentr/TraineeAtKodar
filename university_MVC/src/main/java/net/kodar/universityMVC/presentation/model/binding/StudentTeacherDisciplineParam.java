package net.kodar.universityMVC.presentation.model.binding;

import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.data.entities.Teacher;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StudentTeacherDisciplineParam {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
    @NotNull(message = "Id cannot be null")
    @Min(value = 0, message = "Id cannot be negative")
    private Integer id;

    public StudentTeacherDisciplineParam(Student student, Teacher teacher, Discipline discipline, Integer id) {
        this.student = student;
        this.teacher = teacher;
        this.discipline = discipline;
        this.id = id;
    }

    public StudentTeacherDisciplineParam() {
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

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "StudentTeacherDisciplineService{" +
                "studentId=" + student.getId() +
                ", teacherId=" + teacher.getId() +
                ", disciplineId=" + discipline.getId() +
                ", id=" + id +
                '}';
    }
}
