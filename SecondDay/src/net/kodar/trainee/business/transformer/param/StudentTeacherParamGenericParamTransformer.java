package net.kodar.trainee.business.transformer.param;

import net.kodar.trainee.business.transformer.GenericParamTransformer;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.presentation.parameter.StudentTeacherParam;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StudentTeacherParamGenericParamTransformer implements GenericParamTransformer<StudentTeacherParam, StudentTeacher, StudentTeacher> {
    @Override
    public StudentTeacher apply(StudentTeacherParam studentTeacherParam, StudentTeacher studentTeacher) {

        if (studentTeacher == null) {
            studentTeacher = new StudentTeacher();
            studentTeacher.setId(studentTeacher.getId());
        }
        studentTeacher.setStudentId(studentTeacher.getStudentId());
        studentTeacher.setTeacherId(studentTeacher.getTeacherId());

        return studentTeacher;
    }

    @Override
    public <V> BiFunction<StudentTeacherParam, StudentTeacher, V> andThen(Function<? super StudentTeacher, ? extends V> after) {
        return null;
    }
}
