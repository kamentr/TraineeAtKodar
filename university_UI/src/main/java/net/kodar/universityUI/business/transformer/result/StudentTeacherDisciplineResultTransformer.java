package net.kodar.universityUI.business.transformer.result;

import net.kodar.universityUI.business.transformer.GenericResultTransformer;
import net.kodar.universityUI.data.entities.StudentTeacherDiscipline;
import net.kodar.universityUI.presentation.model.result.StudentTeacherDisciplineResult;
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
