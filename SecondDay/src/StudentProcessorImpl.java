import java.util.ArrayList;
import java.util.List;

public class StudentProcessorImpl implements StudentProcessor {

    private StudentDao studentDao = new StudentDaoImpl();
    private TeacherDao teacherDao = new TeacherDaoImlp();

    @Override
    public Student get(int id) {
        return studentDao.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void save(Student t) {
        studentDao.save(t);
    }

    @Override
    public void update(Student t) {
        studentDao.update(t);
    }

    @Override
    public void delete(Student t) {
        studentDao.delete(t);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public Student getByNumber(String facNumber) {
        int num = Integer.parseInt(facNumber);
        for(Student student:studentDao.getAll()){
            if(student.getfacNumber().equals(facNumber)){
                return student;
            }
        }

        return null;
    }

    @Override
    public List<Student> getByFirstName(String fName) {
        List<Student> students = new ArrayList<>();
        String name = fName;
        for(Student student : studentDao.getAll()){
            if(student.getFirstName().equals(fName)){
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public List<Student> getStudentsByTeacher(Teacher teacher) {
        for(Teacher t : teacherDao.getAll()){
            if(t.getfName().equals(teacher.getfName()) && t.getlName().equals(teacher.getlName())){
                return t.getStudents();
            }
        }
        return null;
    }
}
