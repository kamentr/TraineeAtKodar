package StudentPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoInnerListImpl implements StudentDao {

    private ArrayList<Student> studentData = new ArrayList<Student>(

            Arrays.asList(
                    new Student(1, "Kamen", "Traikov", "1801321018"),
                    new Student(2, "Ivan", "Ivanov", "1801321019"),
                    new Student(3, "Spas", "Todorov", "1801321028"),
                    new Student(4, "Mihail", "Tryanov", "1801321014"),
                    new Student(4, "Inner", "Tryanov", "1801321014")
            )

    );

    @Override
    public Student get(int id) {
        return studentData.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentData;
    }

    @Override
    public void save(Student student) {
        studentData.add(student);
    }

    @Override
    public void update(Student student) {
        Student student1 = get(student.getID());
    }

    @Override
    public void delete(Student student) {
        for(Student s : studentData){
            if(s.getID() == student.getID()){
                studentData.remove(s);
            }
        }
    }

    @Override
    public void delete(int id) {
        studentData.remove(studentData.get(id));
    }
}
