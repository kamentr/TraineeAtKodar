package net.kodar.trainee.business.transformer.param;

import net.kodar.trainee.business.transformer.GenericParamTransformer;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.presentation.parameter.StudentParam;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StudentParamGenericParamTransformer implements
        GenericParamTransformer<StudentParam, Student, Student> {

    @Override
    public Student apply(StudentParam studentParam, Student student) {

        if (student == null) {
            student = new Student();
            student.setID(studentParam.getID());
        }
        student.setFirstName(studentParam.getFirstName());
        student.setLastName(studentParam.getLastName());

        return student;
    }

    @Override
    public <V> BiFunction<StudentParam, Student, V> andThen(Function<? super Student, ? extends V> after) {
        return null;
    }
}
