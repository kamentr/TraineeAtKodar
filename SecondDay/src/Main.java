import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Relation studentTeacher = new StudentTeacher(1,1);
        StudentTeacherRelations studentTeacherRelations = new StudentTeacherRelations();

        studentTeacherRelations.addRelation(1,2);
        studentTeacherRelations.addRelation(2,2);
        studentTeacherRelations.addRelation(3,5);
        studentTeacherRelations.addRelation(3,4);

        studentTeacherRelations.deleteRelation(studentTeacher);

        for (Relation r :  studentTeacherRelations.getAll()) {
            System.out.println("Student: " + r.getKey() + " <-> Teacher: " + r.getValue());
        }
        System.out.println();
        //MainUI mainUI = new MainUI();
    }
}
