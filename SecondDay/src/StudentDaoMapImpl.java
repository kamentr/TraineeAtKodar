import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoMapImpl implements StudentDao {

    StudentDataMap studentDataMap = new StudentDataMap();
    private Map<Integer, Student> studentData = StudentDataMap.studentDataMap;

    @Override
    public Student get(int id) {
        return studentData.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentData.values());
    }

    @Override
    public void save(Student student) {
        studentData.put(student.getID(), student);
    }

    @Override
    public void update(Student student) {
        studentData.put(student.getID(), student);
    }

    @Override
    public void delete(Student student) {
        studentData.remove(student.getID(), student);
    }

    @Override
    public void delete(int id) {
        Student s = studentData.get(id);
        studentData.remove(s.getID(), s);
    }
}
