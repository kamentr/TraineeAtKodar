package net.kodar.universityMVC.business.processor.studentteacherdiscipline;

import net.kodar.universityMVC.business.processor.Processor;
import net.kodar.universityMVC.presentation.model.param.StudentTeacherDisciplineParam;
import net.kodar.universityMVC.presentation.model.result.StudentTeacherDisciplineResult;

import java.util.List;

public interface StudentTeacherDisciplineProcessorGeneric extends Processor<StudentTeacherDisciplineParam, StudentTeacherDisciplineResult> {

    List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId);

    List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
