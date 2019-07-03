package net.kodar.university.business.processor.teacher;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import net.kodar.university.presentation.depricated.result.TeacherResult;

import java.util.List;

public interface TeacherProcessorGeneric extends Processor<TeacherParam, TeacherResult> {

    List<TeacherResult> getTeachersByStudentId(Integer studentId);
}
