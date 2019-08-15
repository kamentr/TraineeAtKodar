package net.kodar.universityMVC.business.transformer.result;

import net.kodar.universityMVC.business.transformer.GenericResultTransformer;
import net.kodar.universityMVC.data.entities.StudentTeacherDiscipline;
import net.kodar.universityMVC.presentation.model.result.StudentTeacherDisciplineResult;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineResultTransformer implements GenericResultTransformer<StudentTeacherDiscipline, StudentTeacherDisciplineResult> {
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
