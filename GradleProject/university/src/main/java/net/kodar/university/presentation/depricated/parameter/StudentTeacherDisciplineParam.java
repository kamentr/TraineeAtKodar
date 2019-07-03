package net.kodar.university.presentation.depricated.parameter;

import net.kodar.university.data.entities.StudentTeacherDiscipline;

import java.util.Objects;

public class StudentTeacherDisciplineParam {

    private Integer studentId;
    private Integer teacherId;
    private Integer disciplineId;
    private Integer id;

    public StudentTeacherDisciplineParam(Integer studentId, Integer teacherId, Integer disciplineId, Integer id) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.disciplineId = disciplineId;
        this.id = id;
    }

    public StudentTeacherDisciplineParam() {
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
        return Objects.equals(studentId, that.getTeacherId()) &&
                Objects.equals(teacherId, that.getTeacherId()) &&
                Objects.equals(disciplineId, that.getDisciplineId()) &&
                Objects.equals(id, that.getId());
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
