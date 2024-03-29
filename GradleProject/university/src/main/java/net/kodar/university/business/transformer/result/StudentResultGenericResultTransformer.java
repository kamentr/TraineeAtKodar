package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.Student;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudentResultGenericResultTransformer implements
        GenericResultTransformer<Student, StudentResult> {


    @Override
    public StudentResult apply(Student student) {

        StudentResult studentResult = new StudentResult();

        studentResult.setFirstName(student.getFirstName());
        studentResult.setId(student.getId());
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
