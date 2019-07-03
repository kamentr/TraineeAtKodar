package net.kodar.university.presentation.depricated.parameter;

public class StudentTeacherParam {
    private Integer studentId;
    private Integer teacherId;
    private Integer id;

    public StudentTeacherParam(int id, int studentId, int teacherId) {
        this.setStudentId(studentId);
        this.setTeacherId(teacherId);
        this.setId(id);
    }

    public StudentTeacherParam() {
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    private void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    private void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
