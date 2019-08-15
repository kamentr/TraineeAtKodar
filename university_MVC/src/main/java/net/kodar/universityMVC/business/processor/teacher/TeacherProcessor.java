package net.kodar.universityMVC.business.processor.teacher;

import net.kodar.universityMVC.business.processor.Processor;
import net.kodar.universityMVC.presentation.model.param.TeacherParam;
import net.kodar.universityMVC.presentation.model.result.TeacherResult;

import java.util.List;

@org.springframework.stereotype.Service
public interface TeacherProcessor extends Processor<TeacherParam, TeacherResult> {

   List<TeacherResult> getTeachersByStudentId(Integer studentId);
}
