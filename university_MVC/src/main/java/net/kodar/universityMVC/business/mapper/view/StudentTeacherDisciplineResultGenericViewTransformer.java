package net.kodar.universityMVC.business.mapper.view;

import net.kodar.universityMVC.business.mapper.GenericViewTransformer;
import net.kodar.universityMVC.data.entities.StudentTeacherDiscipline;
import net.kodar.universityMVC.presentation.model.view.StudentTeacherDisciplineResult;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineResultGenericViewTransformer implements GenericViewTransformer<StudentTeacherDiscipline, StudentTeacherDisciplineResult> {
    @Override
    public StudentTeacherDisciplineResult apply(StudentTeacherDiscipline studentTeacherDiscipline) {

        StudentTeacherDisciplineResult studentTeacherDisciplineResult = new StudentTeacherDisciplineResult();

        studentTeacherDisciplineResult.setDiscipline(studentTeacherDiscipline.getDiscipline());
        studentTeacherDisciplineResult.setId(studentTeacherDiscipline.getId());
        studentTeacherDisciplineResult.setStudent(studentTeacherDiscipline.getStudent());
        studentTeacherDisciplineResult.setTeacher(studentTeacherDiscipline.getTeacher());

        return studentTeacherDisciplineResult;
    }
}
