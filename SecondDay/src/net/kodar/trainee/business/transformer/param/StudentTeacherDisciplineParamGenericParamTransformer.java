package net.kodar.trainee.business.transformer.param;

import net.kodar.trainee.business.transformer.GenericParamTransformer;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StudentTeacherDisciplineParamGenericParamTransformer implements GenericParamTransformer<StudentTeacherDisciplineParam, StudentTeacherDiscipline, StudentTeacherDiscipline> {
    @Override
    public StudentTeacherDiscipline apply(StudentTeacherDisciplineParam studentTeacherDisciplineParam, StudentTeacherDiscipline studentTeacherDiscipline) {
        if(studentTeacherDiscipline == null){
            studentTeacherDiscipline = new StudentTeacherDiscipline();
            studentTeacherDiscipline.setId(studentTeacherDisciplineParam.getId());
        }

        studentTeacherDiscipline.setDisciplineId(studentTeacherDisciplineParam.getDisciplineId());
        studentTeacherDiscipline.setStudentId(studentTeacherDisciplineParam.getStudentId());
        studentTeacherDiscipline.setTeacherId(studentTeacherDisciplineParam.getTeacherId());

        return studentTeacherDiscipline;
    }

    @Override
    public <V> BiFunction<StudentTeacherDisciplineParam, StudentTeacherDiscipline, V> andThen(Function<? super StudentTeacherDiscipline, ? extends V> after) {
        return null;
    }
}
