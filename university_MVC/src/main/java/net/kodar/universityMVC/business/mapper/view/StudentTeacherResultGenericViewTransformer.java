package net.kodar.universityMVC.business.mapper.view;

import net.kodar.universityMVC.business.mapper.GenericViewTransformer;
import net.kodar.universityMVC.data.entities.StudentTeacher;
import net.kodar.universityMVC.presentation.model.view.StudentTeacherResult;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherResultGenericViewTransformer implements GenericViewTransformer<StudentTeacher, StudentTeacherResult> {

    @Override
    public StudentTeacherResult apply(StudentTeacher studentTeacher) {
        StudentTeacherResult studentTeacherResult = new StudentTeacherResult();
        studentTeacherResult.setId(studentTeacher.getId());
        studentTeacherResult.setStudent(studentTeacher.getStudent());
        studentTeacherResult.setTeacher(studentTeacher.getTeacher());

        return studentTeacherResult;
    }
}
