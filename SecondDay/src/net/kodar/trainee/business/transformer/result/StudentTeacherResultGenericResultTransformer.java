package net.kodar.trainee.business.transformer.result;

import net.kodar.trainee.business.transformer.GenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

public class StudentTeacherResultGenericResultTransformer implements GenericResultTransformer<StudentTeacher, StudentTeacherResult> {

    @Override
    public StudentTeacherResult apply(StudentTeacher studentTeacher) {
        StudentTeacherResult studentTeacherResult = new StudentTeacherResult();
        studentTeacherResult.setId(studentTeacher.getId());
        studentTeacherResult.setStudentId(studentTeacher.getStudentId());
        studentTeacherResult.setTeacherId(studentTeacher.getTeacherId());

        return studentTeacherResult;
    }
}
