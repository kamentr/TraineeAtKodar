package net.kodar.universityMVC.presentation.model.result;

import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.data.entities.Teacher;

public class StudentTeacherDisciplineResult {

    private Student student;
    private Teacher teacher;
    private Discipline discipline;
    private Integer id;


    public StudentTeacherDisciplineResult(Student student, Teacher teacher, Discipline discipline, Integer id) {
        this.student = student;
        this.teacher = teacher;
        this.discipline = discipline;
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

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public StudentTeacherDisciplineResult() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentTeacherDisciplineResult{" +
                "student=" + this.student.getId() +
                ", teacher=" + this.teacher.getId() +
                ", discipline=" + this.discipline.getId() +
                ", id=" + id +
                '}';
    }
}
