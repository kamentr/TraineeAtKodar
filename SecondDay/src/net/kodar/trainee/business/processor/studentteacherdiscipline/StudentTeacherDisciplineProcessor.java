package net.kodar.trainee.business.processor.studentteacherdiscipline;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;

import java.util.List;

public interface StudentTeacherDisciplineProcessor extends Processor<StudentTeacherDiscipline> {

    List<StudentTeacherDiscipline> filterByTeacher(Integer techerId);

    List<StudentTeacherDiscipline> filterByStudent(Integer studentId);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
