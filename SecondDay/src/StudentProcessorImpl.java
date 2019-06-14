import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class StudentProcessorImpl implements StudentProcessor {

    private ArrayList<Student> studentData;
    private StudentDaoImpl studentDaoImpl = new StudentDaoImpl() {


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
            student.setID(Objects.requireNonNull(Integer.parseInt(params[0]), "Id cannot be null"));
            student.setFirstName(Objects.requireNonNull(params[1], "Name cannot be null"));
            student.setLastName(Objects.requireNonNull(params[2], "Name cannot be null"));
            student.setNumber(Objects.requireNonNull(params[3], "Name cannot be null"));
        }

        @Override
        public void delete(Student student) {
            if (studentData.contains(student))
                studentData.remove(student);
        }
    };


    public ArrayList<Student> getAllStudents() {
        return studentDaoImpl.getAll();
    }

    public StudentProcessorImpl() {
        this.studentData = studentDaoImpl.studentData;
    }

    public Student getByNumber(String number) {

        for (int i = 0; i < studentData.size(); i++) {
            if (studentData.get(i).getNumber() == number)
                return studentData.get(i);
        }

        return null;
    }


    public Student getByFirstName(String fName) {

        for (Student student : StudentData.studentData) {
            if (student.getFirstName() == fName)
                return student;
        }

        return null;
    }

    @Override
    public ArrayList<Student> getStudentsByTeacher(Teacher teacher) {

        return teacher.getStudents() != null ? teacher.getStudents() : null;
    }

}
