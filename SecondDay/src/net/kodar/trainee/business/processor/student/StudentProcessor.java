package net.kodar.trainee.business.processor.student;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.presentation.parameter.StudentParam;
import net.kodar.trainee.presentation.result.StudentResult;

import java.util.List;

public interface StudentProcessor extends Processor<StudentParam, StudentResult> {

    List<StudentResult> getStudentsByTeacherId(Integer teacherId);

}
