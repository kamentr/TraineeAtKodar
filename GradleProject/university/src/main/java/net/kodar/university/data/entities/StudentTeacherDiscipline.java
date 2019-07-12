package net.kodar.university.data.entities;

import javax.persistence.*;

@Entity
public class StudentTeacherDiscipline {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public StudentTeacherDiscipline(Integer id, Student student, Teacher teacher, Discipline discipline) {
        this.id = id;
        this.student = student;
        this.teacher = teacher;
        this.discipline = discipline;
    }

    public StudentTeacherDiscipline() {

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
