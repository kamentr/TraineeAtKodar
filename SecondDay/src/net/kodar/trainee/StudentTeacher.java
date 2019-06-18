package net.kodar.trainee;

import javax.security.auth.Subject;

public class StudentTeacher {

    private Integer studentId;
    private Integer teacherId;


    public StudentTeacher(int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
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
