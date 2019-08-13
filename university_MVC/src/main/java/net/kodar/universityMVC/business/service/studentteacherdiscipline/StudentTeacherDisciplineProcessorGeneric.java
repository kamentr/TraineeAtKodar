package net.kodar.universityMVC.business.service.studentteacherdiscipline;

import net.kodar.universityMVC.business.service.Service;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherDisciplineParam;
import net.kodar.universityMVC.presentation.model.view.StudentTeacherDisciplineResult;

import java.util.List;

public interface StudentTeacherDisciplineProcessorGeneric extends Service<StudentTeacherDisciplineParam, StudentTeacherDisciplineResult> {

    List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId);

    List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
