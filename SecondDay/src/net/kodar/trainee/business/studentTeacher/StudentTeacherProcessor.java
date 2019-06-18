package net.kodar.trainee.business.studentTeacher;

import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.data.entities.Teacher;

import java.util.List;

public interface StudentTeacherProcessor {

    List<Integer> getByTeacherId(int id);

    List<Integer> getByStudentId(int id);

    List<Student> getStudentsByTeacher(Teacher teacher);

    List<Teacher> getTeachersByStudent(Student student);

    List<StudentTeacher> filterByStudent(Integer id);

    List<StudentTeacher> filterByTeacher(Integer id);
}
