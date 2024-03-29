package net.kodar.university.business.transformer.param;

import net.kodar.university.business.transformer.GenericParamTransformer;
import net.kodar.university.data.entities.Teacher;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class TeacherParamGenericParamTransformer implements GenericParamTransformer<TeacherParam, Teacher, Teacher> {
    @Override
    public Teacher apply(TeacherParam teacherParam, Teacher teacher) {

        if (teacher == null) {
            teacher = new Teacher();
            teacher.setId(teacherParam.getId());
        }
        teacher.setFirstName(teacherParam.getFirstName());
        teacher.setLastName(teacherParam.getLastName());

        return teacher;
    }

    @Override
    public <V> BiFunction<TeacherParam, Teacher, V> andThen(Function<? super Teacher, ? extends V> after) {
        return null;
    }
}
