package net.kodar.universityUI.business.transformer.param;

import net.kodar.universityUI.business.transformer.GenericParamTransformer;
import net.kodar.universityUI.data.entities.StudentTeacher;
import net.kodar.universityUI.presentation.model.param.StudentTeacherParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class StudentTeacherParamTransformer implements GenericParamTransformer<StudentTeacherParam, StudentTeacher, StudentTeacher> {
    @Override
    public StudentTeacher apply(StudentTeacherParam studentTeacherParam, StudentTeacher studentTeacher) {

        if (studentTeacher == null) {
            studentTeacher = new StudentTeacher();
            studentTeacher.setId(studentTeacher.getId());
        }
        studentTeacher.setStudent(studentTeacher.getStudent());
        studentTeacher.setTeacher(studentTeacher.getTeacher());

        return studentTeacher;
    }

    @Override
    public <V> BiFunction<StudentTeacherParam, StudentTeacher, V> andThen(Function<? super StudentTeacher, ? extends V> after) {
        return null;
    }
}
