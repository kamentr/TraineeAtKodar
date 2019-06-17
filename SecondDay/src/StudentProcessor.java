import java.util.List;

public interface StudentProcessor {

    Student get(int id);

    List<Student> getAll();

    void save(Student t);

    void update(Student t);

    void delete(Student t);

    void delete(int id);

    Student getByNumber(String number);

    List<Student> getByFirstName(String fName);

    List<Student> getStudentsByTeacher(Teacher teacher);

}
