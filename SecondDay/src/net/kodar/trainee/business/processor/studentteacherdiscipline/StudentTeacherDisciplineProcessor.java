package net.kodar.trainee.business.processor.studentteacherdiscipline;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

import java.util.List;

public interface StudentTeacherDisciplineProcessor extends Processor<StudentTeacherDisciplineParam, StudentTeacherDisciplineResult> {

    List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId);

    List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
