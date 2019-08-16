package net.kodar.universityUI.business.transformer.param;

import net.kodar.universityUI.business.transformer.GenericParamTransformer;
import net.kodar.universityUI.data.entities.StudentTeacherDiscipline;
import net.kodar.universityUI.presentation.model.param.StudentTeacherDisciplineParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class StudentTeacherDisciplineParamTransformer implements GenericParamTransformer<StudentTeacherDisciplineParam, StudentTeacherDiscipline, StudentTeacherDiscipline> {

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
