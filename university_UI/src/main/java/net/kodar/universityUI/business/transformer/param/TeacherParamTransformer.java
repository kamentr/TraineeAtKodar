package net.kodar.universityUI.business.transformer.param;

import net.kodar.universityUI.business.transformer.GenericParamTransformer;
import net.kodar.universityUI.data.entities.Teacher;
import net.kodar.universityUI.presentation.model.param.TeacherParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class TeacherParamTransformer implements GenericParamTransformer<TeacherParam, Teacher, Teacher> {
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
