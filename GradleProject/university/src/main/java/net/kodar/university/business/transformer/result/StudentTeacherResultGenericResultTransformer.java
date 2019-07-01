package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.presentation.result.StudentTeacherResult;

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
