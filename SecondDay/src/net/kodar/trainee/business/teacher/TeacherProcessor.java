package net.kodar.trainee.business.teacher;

import net.kodar.trainee.business.Processor;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDao;

import java.util.List;

public interface TeacherProcessor extends Processor<Teacher> {

    List<Teacher> getTeachersByStudent(Student student);

}
