import java.util.Map;

public class StudentTeacher {

    private Integer studetnId;
    private Integer teacherId;

    public StudentTeacher(int studetnId, int teacherId) {
        this.studetnId = studetnId;
        this.teacherId = teacherId;
    }

    public Integer getStudetnId() {
        return studetnId;
    }

    public void setStudetnId(Integer studetnId) {
        this.studetnId = studetnId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

}
