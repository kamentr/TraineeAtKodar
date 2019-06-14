import java.util.*;

public class StudentDaoImpl implements StudentDao {

    public ArrayList<Student> studentData;

    public ArrayList<Student> getStudentData() {
        return studentData;
    }

    public StudentDaoImpl(){
        this.studentData = StudentData.studentData;
    }
    @Override
    public Student get(int id) {
        return studentData.get(id);
    }

    @Override
    public ArrayList<Student> getAll() {
        return studentData;
    }

    @Override
    public void save(Student student) {
        studentData.add(student);
    }

    @Override
    public void update(Student student, String[] params) {
        if(studentData.contains(student)) {
            student.setID(Objects.requireNonNull(Integer.parseInt(params[0]), "Id cannot be null"));
            student.setFirstName(Objects.requireNonNull(params[1], "Name cannot be null"));
            student.setLastName(Objects.requireNonNull(params[2], "Name cannot be null"));
            student.setNumber(Objects.requireNonNull(params[3], "Name cannot be null"));
        }
    }

    @Override
    public void delete(Student student) {
        if (studentData.contains(student))
        studentData.remove(student);
    }
}
