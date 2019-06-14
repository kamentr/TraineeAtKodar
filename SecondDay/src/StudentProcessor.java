import java.util.ArrayList;
import java.util.Optional;

public interface StudentProcessor{

    public StudentDaoImpl studentDao = new StudentDaoImpl() {
        @Override
        public Student get(int id) {
            return studentDao.get(id);
        }

        @Override
        public ArrayList<Student> getAll() {
            return studentDao.getAll();

        }

        @Override
        public void save(Student student) {
            studentDao.save(student);
        }

        @Override
        public void update(Student student, String[] params) {
            studentDao.update(student, params);
        }

        @Override
        public void delete(Student student) {
            studentDao.delete(student);
        }
    };

    public Student getByNumber(String number);

    public Student getByFirstName(String fName);

    public ArrayList<Student> getStudentsByTeacher();

}
