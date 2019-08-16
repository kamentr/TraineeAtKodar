package net.kodar.universityUI.business.processor.teacher;


import net.kodar.universityUI.business.processor.Processor;
import net.kodar.universityUI.presentation.model.param.TeacherParam;
import net.kodar.universityUI.presentation.model.result.TeacherResult;

import java.util.List;

@org.springframework.stereotype.Service
public interface TeacherProcessor extends Processor<TeacherParam, TeacherResult> {

   List<TeacherResult> getTeachersByStudentId(Integer studentId);
}
