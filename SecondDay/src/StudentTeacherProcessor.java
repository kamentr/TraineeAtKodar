import java.util.List;

interface StudentTeacherProcessor {

    List<Student> getByTeacherId(int id);

    List<Teacher> getByStudentId(int id);

    List<Student> getByTeacher(Teacher teacher);

    List<Teacher> getByStudent(Student student);
}
