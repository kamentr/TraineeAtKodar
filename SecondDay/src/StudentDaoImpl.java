import java.util.*;

public class StudentDaoImpl implements StudentDao {

    protected ArrayList<Student> studentData;

    public StudentDaoImpl(){
        this.studentData = StudentData.studentData;
    }
    @Override
    public Optional<Student> get(int id) {

        return Optional.ofNullable(studentData.get((int) id));
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
        student.setID(Objects.requireNonNull(Integer.parseInt(params[0]), "Id cannot be null"));
        student.setFirstName(Objects.requireNonNull(params[1], "Name cannot be null"));
        student.setLastName(Objects.requireNonNull(params[2], "Name cannot be null"));
        student.setNumber(Objects.requireNonNull(params[3], "Name cannot be null"));
    }

    @Override
    public void delete(Student student) {
        //if (studentData.contains(student))
        studentData.remove(student);
    }
}
