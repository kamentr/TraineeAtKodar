package net.kodar.trainee.data.entities;

public class StudentTeacher {

    private Integer studentId;
    private Integer teacherId;
    private Integer id;

    public StudentTeacher(int id , int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.id = id;
    }

    public StudentTeacher(int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
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
