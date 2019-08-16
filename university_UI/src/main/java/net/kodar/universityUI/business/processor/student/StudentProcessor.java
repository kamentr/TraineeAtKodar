package net.kodar.universityUI.business.processor.student;


import net.kodar.universityUI.business.processor.Processor;
import net.kodar.universityUI.presentation.model.param.StudentParam;
import net.kodar.universityUI.presentation.model.result.StudentResult;

import java.util.List;

@org.springframework.stereotype.Service
public interface StudentProcessor extends Processor<StudentParam, StudentResult> {

    List<StudentResult> getStudentsByTeacherId(Integer teacherId);

}
