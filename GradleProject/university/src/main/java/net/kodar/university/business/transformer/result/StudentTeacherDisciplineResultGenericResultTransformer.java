package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.StudentTeacherDiscipline;
import net.kodar.university.presentation.result.StudentTeacherDisciplineResult;

public class StudentTeacherDisciplineResultGenericResultTransformer implements GenericResultTransformer<StudentTeacherDiscipline, StudentTeacherDisciplineResult> {
    @Override
    public StudentTeacherDisciplineResult apply(StudentTeacherDiscipline studentTeacherDiscipline) {

        StudentTeacherDisciplineResult studentTeacherDisciplineResult = new StudentTeacherDisciplineResult();

        studentTeacherDisciplineResult.setDisciplineId(studentTeacherDiscipline.getDisciplineId());
        studentTeacherDisciplineResult.setId(studentTeacherDiscipline.getId());
        studentTeacherDisciplineResult.setStudentId(studentTeacherDiscipline.getStudentId());
        studentTeacherDisciplineResult.setTeacherId(studentTeacherDiscipline.getTeacherId());

        return studentTeacherDisciplineResult;
    }
}
