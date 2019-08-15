package net.kodar.universityMVC.business.processor.student;

import net.kodar.universityMVC.business.processor.Processor;
import net.kodar.universityMVC.presentation.model.param.StudentParam;
import net.kodar.universityMVC.presentation.model.result.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.result.StudentResult;

import java.util.List;

@org.springframework.stereotype.Service
public interface StudentProcessor extends Processor<StudentParam, StudentResult> {

    List<StudentResult> getStudentsByTeacherId(Integer teacherId);

    StudentDetailsView getDetailsByStudentId(Integer studentId);
}
