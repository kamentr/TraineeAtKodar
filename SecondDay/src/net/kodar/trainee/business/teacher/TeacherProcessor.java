package net.kodar.trainee.business.teacher;

import net.kodar.trainee.business.Processor;
import net.kodar.trainee.data.entities.Teacher;

import java.util.List;

public interface TeacherProcessor extends Processor<Teacher> {

    List<Teacher> getTeachersByStudentId(Integer studentId);

}
