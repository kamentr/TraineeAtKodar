import java.util.*;

public class StudentDaoImpl implements StudentDao {


    private List<Student> getStudentData() {
        return StudentData.studentData;
    }

    @Override
    public Student get(int id) {
        return getStudentData().get(id);
    }

    @Override
    public List<Student> getAll() {
        return getStudentData();
    }

    @Override
    public void save(Student student) {
        getStudentData().add(student);
    }

    @Override
    public void update(Student student) {
            Student student1 = get(student.getID());
    }

    @Override
    public void delete(Student student) {
        for(Student s : getStudentData()){
            if(s.getID() == student.getID()){
                getStudentData().remove(s);
            }
        }
    }

    @Override
    public void delete(int id) {
        getStudentData().remove(getStudentData().get(id));
    }
}
