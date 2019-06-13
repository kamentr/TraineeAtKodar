import java.util.ArrayList;
import java.util.Optional;

public interface StudentProcessor {

    public StudentDao studentDao = new StudentDao() {
        @Override
        public Optional<Student> get(int id) {
            return Optional.empty();
        }

        @Override
        public ArrayList<Student> getAll() {
            return null;
        }

        @Override
        public void save(Student student) {

        }

        @Override
        public void update(Student student, String[] params) {

        }

        @Override
        public void delete(Student student) {

        }
    };

    public Student getByNumber(String number);

    public  Student getByFirstName(String fName);
}
