package net.kodar.trainee.presentation.result;

import java.util.UUID;

public class StudentTeacherResult {
    private Integer studentId;
    private Integer teacherId;
    private Integer id;
    private UUID identifier;

    public StudentTeacherResult(int id, int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.id = id;
    }

    public StudentTeacherResult(int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
    }


    public StudentTeacherResult() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
