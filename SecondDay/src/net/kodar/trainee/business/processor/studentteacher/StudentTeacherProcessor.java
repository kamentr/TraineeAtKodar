package net.kodar.trainee.business.processor.studentteacher;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.presentation.parameter.StudentTeacherParam;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

import java.util.List;

public interface StudentTeacherProcessor extends Processor<StudentTeacherParam, StudentTeacherResult> {

    List<StudentTeacher> filterByStudent(Integer id);

    List<StudentTeacher> filterByTeacher(Integer id);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
