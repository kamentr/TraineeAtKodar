package net.kodar.university.business.processor.student;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;

import java.util.List;

public interface StudentProcessorGeneric extends Processor<StudentParam, StudentResult> {

    List<StudentResult> getStudentsByTeacherId(Integer teacherId);

}
