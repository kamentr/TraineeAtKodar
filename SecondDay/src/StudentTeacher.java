public class StudentTeacher implements Relation<Integer, Integer>{

    private Integer studentId;
    private Integer teacherId;

    public StudentTeacher(int studentId, int teacherId) {
        this.studentId = studentId;
        this.teacherId = teacherId;
    }

    @Override
    public Integer getKey() {
        return studentId;
    }

    @Override
    public Integer getValue() {
        return teacherId;
    }
}
