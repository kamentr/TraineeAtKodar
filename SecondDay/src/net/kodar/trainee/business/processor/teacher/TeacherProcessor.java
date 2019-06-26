package net.kodar.trainee.business.processor.teacher;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.presentation.parameter.TeacherParam;
import net.kodar.trainee.presentation.result.TeacherResult;

import java.util.List;

public interface TeacherProcessor extends Processor<TeacherParam, TeacherResult>{

    List<TeacherResult> getTeachersByStudentId(Integer studentId);

}
