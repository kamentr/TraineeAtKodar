package net.kodar.university.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class StudentTeacherDiscipline {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name="ID")
    private Integer studentId;

    @JoinColumn(name = "id")
    private Integer teacherId;

    @JoinColumn(name = "id")
    private Integer disciplineId;
    private UUID identifier;

    public StudentTeacherDiscipline(Integer studentId, Integer teacherId, Integer disciplineId, Integer id) {
        this.setStudentId(studentId);
        this.setTeacherId(teacherId);
        this.setDisciplineId(disciplineId);
        this.setId(id);
        this.setIdentifier(UUID.randomUUID());
    }

    public StudentTeacherDiscipline() {
        this.setIdentifier(UUID.randomUUID());
    }

    public UUID getIdentifier() {
        return identifier;
    }

    private void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentTeacherDiscipline)) return false;
        StudentTeacherDiscipline that = (StudentTeacherDiscipline) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(teacherId, that.teacherId) &&
                Objects.equals(disciplineId, that.disciplineId) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, teacherId, disciplineId, id);
    }

    @Override
    public String toString() {
        return "StudentTeacherDisciplineService{" +
                "studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", disciplineId=" + disciplineId +
                ", id=" + id +
                '}';
    }
}
