package net.kodar.universityMVC.business.service.teacher;

import net.kodar.universityMVC.business.service.Service;
import net.kodar.universityMVC.presentation.model.binding.TeacherParam;
import net.kodar.universityMVC.presentation.model.view.TeacherView;

import java.util.List;

@org.springframework.stereotype.Service
public interface TeacherService extends Service<TeacherParam, TeacherView> {

   List<TeacherView> getTeachersByStudentId(Integer studentId);
}
