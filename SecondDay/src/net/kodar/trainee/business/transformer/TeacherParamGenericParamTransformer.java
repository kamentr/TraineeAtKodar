package net.kodar.trainee.business.transformer;

import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.presentation.parameter.StudentParam;
import net.kodar.trainee.presentation.parameter.TeacherParam;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TeacherParamGenericParamTransformer implements GenericParamTransformer<TeacherParam, Teacher, Teacher> {
    @Override
    public Teacher apply(TeacherParam teacherParam, Teacher teacher) {

        if (teacher == null) {
            teacher = new Teacher();
            teacher.setId(teacherParam.getId());
        }
        teacher.setfName(teacherParam.getfName());
        teacher.setlName(teacherParam.getlName());

        return teacher;
    }

    @Override
    public <V> BiFunction<TeacherParam, Teacher, V> andThen(Function<? super Teacher, ? extends V> after) {
        return null;
    }
}
