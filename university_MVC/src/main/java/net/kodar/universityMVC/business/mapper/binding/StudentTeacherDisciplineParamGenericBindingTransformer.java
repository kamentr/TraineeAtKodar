package net.kodar.universityMVC.business.mapper.binding;

import net.kodar.universityMVC.business.mapper.GenericBindingTransformer;
import net.kodar.universityMVC.data.entities.StudentTeacherDiscipline;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherDisciplineParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class StudentTeacherDisciplineParamGenericBindingTransformer implements GenericBindingTransformer<StudentTeacherDisciplineParam, StudentTeacherDiscipline, StudentTeacherDiscipline> {

    @Override
    public StudentTeacherDiscipline apply(StudentTeacherDisciplineParam studentTeacherDisciplineParam, StudentTeacherDiscipline studentTeacherDiscipline) {
        if(studentTeacherDiscipline == null){
            studentTeacherDiscipline = new StudentTeacherDiscipline();
            studentTeacherDiscipline.setId(studentTeacherDisciplineParam.getId());
        }

        studentTeacherDiscipline.setDiscipline(studentTeacherDisciplineParam.getDiscipline());
        studentTeacherDiscipline.setStudent(studentTeacherDisciplineParam.getStudent());
        studentTeacherDiscipline.setTeacher(studentTeacherDisciplineParam.getTeacher());

        return studentTeacherDiscipline;
    }

    @Override
    public <V> BiFunction<StudentTeacherDisciplineParam, StudentTeacherDiscipline, V> andThen(Function<? super StudentTeacherDiscipline, ? extends V> after) {
        return null;
    }
}
