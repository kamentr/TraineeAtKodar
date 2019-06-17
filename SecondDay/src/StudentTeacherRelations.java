import java.util.ArrayList;
import java.util.List;

public class StudentTeacherRelations implements Relation {

    private List<StudentTeacher> relations = new ArrayList<>();

    @Override
    public void addRelation(Object studentId, Object teacherId) {
        if(!relations.contains(new StudentTeacher((Integer) studentId, (Integer)teacherId)))
        relations.add(new StudentTeacher((Integer) studentId, (Integer)teacherId));
    }

    @Override
    public void deleteRelation(Object studentId, Object teacherId) {
        relations.remove(new StudentTeacher((Integer) studentId, (Integer)teacherId));
    }

    @Override
    public void deleteRelation(Relation relation) {
        relations.remove(relation);
    }
}
