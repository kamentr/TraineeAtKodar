package net.kodar.universityMVC.business.mapper.binding;

import net.kodar.universityMVC.business.mapper.GenericBindingTransformer;
import net.kodar.universityMVC.data.entities.StudentTeacher;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class StudentTeacherParamGenericBindingTransformer implements GenericBindingTransformer<StudentTeacherParam, StudentTeacher, StudentTeacher> {
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
