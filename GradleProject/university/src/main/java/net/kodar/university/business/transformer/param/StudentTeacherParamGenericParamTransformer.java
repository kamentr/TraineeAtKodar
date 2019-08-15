package net.kodar.university.business.transformer.param;

import net.kodar.university.business.transformer.GenericParamTransformer;
import net.kodar.university.entities.StudentTeacher;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class StudentTeacherParamGenericParamTransformer implements GenericParamTransformer<StudentTeacherParam, StudentTeacher, StudentTeacher> {
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
