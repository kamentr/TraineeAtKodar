package net.kodar.trainee.business.student;

import net.kodar.trainee.business.Processor;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;

import java.util.List;

public interface StudentProcessor extends Processor<Student> {

    List<Student> getStudentsByTeacher(Teacher teacher);

}
