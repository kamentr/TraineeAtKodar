package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.StudentTeacherDiscipline;
import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineResultGenericResultTransformer implements GenericResultTransformer<StudentTeacherDiscipline, StudentTeacherDisciplineResult> {
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
