package net.kodar.trainee.presentation.parameter;

public class StudentTeacherParam {
    private Integer studentId;
    private Integer teacherId;
    private Integer id;

    public StudentTeacherParam(int id, int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.id = id;
    }

    public StudentTeacherParam(int studentId, int teacherId) {
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
