package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.entities.StudentTeacher;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherResultGenericResultTransformer implements GenericResultTransformer<StudentTeacher, StudentTeacherResult> {

    @Override
    public StudentTeacherResult apply(StudentTeacher studentTeacher) {
        StudentTeacherResult studentTeacherResult = new StudentTeacherResult();
        studentTeacherResult.setId(studentTeacher.getId());
        studentTeacherResult.setStudent(studentTeacher.getStudent());
        studentTeacherResult.setTeacher(studentTeacher.getTeacher());

        return studentTeacherResult;
    }
}
