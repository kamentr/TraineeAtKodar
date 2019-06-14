import java.util.List;

public interface StudentProcessor {

    Student get(int id);

    List<Student> getAll();

    void save(Student t);

    void update(Student t);

    void delete(Student t);

    void delete(int id);

    public Student getByNumber(String number);

    public List<Student> getByFirstName(String fName);

    public List<Student> getStudentsByTeacher(Teacher teacher);

}
