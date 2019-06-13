import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class StudentProcessorImpl implements StudentProcessor {

    private StudentDao studentDao = new StudentDao() {
        public Optional<Student> get(int id) {

            return Optional.ofNullable(StudentData.studentData.get((int) id));
        }

        @Override
        public ArrayList<Student> getAll() {
            return StudentData.studentData;
        }

        @Override
        public void save(Student student) {
            StudentData.studentData.add(student);
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
            StudentData.studentData.remove(student);
        }
    };

    public Student getByNumber(String number) {

        for (Student student: StudentData.studentData) {
            if(student.getNumber() == number)
                return student;
        }

        return null;
    }


    public Student getByFirstName(String fName) {

        for (Student student: StudentData.studentData) {
            if(student.getFirstName() == fName)
                return student;
        }

        return null;
    }

}
