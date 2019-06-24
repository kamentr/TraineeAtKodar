package net.kodar.trainee.business.transformer.result;

import net.kodar.trainee.business.transformer.GenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

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
