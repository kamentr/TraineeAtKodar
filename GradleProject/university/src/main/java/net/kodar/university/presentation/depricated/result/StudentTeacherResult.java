package net.kodar.university.presentation.depricated.result;


import net.kodar.university.entities.Student;
import net.kodar.university.entities.Teacher;

public class StudentTeacherResult {

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Student student;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Teacher teacher;

    private Integer id;

    public StudentTeacherResult(Student student, Teacher teacher, Integer id) {
        this.student = student;
        this.teacher = teacher;
        this.id = id;
    }

    public StudentTeacherResult() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentTeacherResult{" +
                "student=" + student.getId() +
                ", teacher=" + teacher.getId() +
                ", id=" + id +
                '}';
    }
}
