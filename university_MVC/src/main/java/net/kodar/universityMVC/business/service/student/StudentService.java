package net.kodar.universityMVC.business.service.student;

import net.kodar.universityMVC.business.service.Service;
import net.kodar.universityMVC.presentation.model.binding.StudentBinding;
import net.kodar.universityMVC.presentation.model.view.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.view.StudentView;

import java.util.List;

@org.springframework.stereotype.Service
public interface StudentService extends Service<StudentBinding, StudentView> {

    List<StudentView> getStudentsByTeacherId(Integer teacherId);

    StudentDetailsView getDetailsByStudentId(Integer studentId);
}
