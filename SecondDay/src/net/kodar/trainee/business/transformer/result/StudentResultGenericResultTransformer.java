package net.kodar.trainee.business.transformer.result;

import net.kodar.trainee.business.transformer.GenericResultTransformer;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.presentation.result.StudentResult;

import java.util.function.Function;

public class StudentResultGenericResultTransformer implements
        GenericResultTransformer<Student, StudentResult> {


    @Override
    public StudentResult apply(Student student) {

        StudentResult studentResult = new StudentResult();

        studentResult.setFirstName(student.getFirstName());
        studentResult.setID(student.getID());
        studentResult.setLastName(student.getLastName());

        return studentResult;
    }

    @Override
    public <V> Function<V, StudentResult> compose(Function<? super V, ? extends Student> before) {
        return null;
    }

    @Override
    public <V> Function<Student, V> andThen(Function<? super StudentResult, ? extends V> after) {
        return null;
    }
}
