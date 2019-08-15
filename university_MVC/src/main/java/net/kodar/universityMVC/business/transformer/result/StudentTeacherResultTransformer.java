package net.kodar.universityMVC.business.transformer.result;

import net.kodar.universityMVC.business.transformer.GenericResultTransformer;
import net.kodar.universityMVC.data.entities.StudentTeacher;
import net.kodar.universityMVC.presentation.model.result.StudentTeacherResult;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherResultTransformer implements GenericResultTransformer<StudentTeacher, StudentTeacherResult> {

    @Override
    public StudentTeacherResult apply(StudentTeacher studentTeacher) {
        StudentTeacherResult studentTeacherResult = new StudentTeacherResult();
        studentTeacherResult.setId(studentTeacher.getId());
        studentTeacherResult.setStudent(studentTeacher.getStudent());
        studentTeacherResult.setTeacher(studentTeacher.getTeacher());

        return studentTeacherResult;
    }
}
