import java.util.ArrayList;
import java.util.List;

public class StudentTeacherRelations implements RelationController {

    private List<Relation<Integer, Integer>> relations = new ArrayList<>();

    public List<Relation<Integer,Integer>> getAll(){
        return relations;
    }

    public void addRelation(int studentId, int teacherId) {
        if(!relations.contains(new StudentTeacher(studentId, teacherId)))
        relations.add(new StudentTeacher(studentId, teacherId));
    }

    public void deleteRelation(int studentId, int teacherId) {
        relations.remove(new StudentTeacher(studentId, teacherId));
    }


    @Override
    public void addRelation(Relation relation) {
        if(!relations.contains(relation)){
            relations.add(relation);
        }

    }

    public void deleteRelation(Relation relation) {
        relations.remove(relation);
    }


}
