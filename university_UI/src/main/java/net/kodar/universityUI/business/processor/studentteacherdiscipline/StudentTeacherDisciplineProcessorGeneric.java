package net.kodar.universityUI.business.processor.studentteacherdiscipline;

import net.kodar.universityUI.business.processor.Processor;
import net.kodar.universityUI.presentation.model.param.StudentTeacherDisciplineParam;
import net.kodar.universityUI.presentation.model.result.StudentTeacherDisciplineResult;

import java.util.List;

public interface StudentTeacherDisciplineProcessorGeneric extends Processor<StudentTeacherDisciplineParam, StudentTeacherDisciplineResult> {

    List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId);

    List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
