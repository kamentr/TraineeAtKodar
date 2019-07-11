package net.kodar.university.business.processor.studentteacher;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;

import java.util.List;

public interface StudentTeacherProcessorGeneric extends Processor<StudentTeacherParam, StudentTeacherResult> {

    List<StudentTeacherResult> filterByStudent(Integer id);

    List<StudentTeacherResult> filterByTeacher(Integer id);

}
