package net.kodar.universityUI.business.transformer.result;


import net.kodar.universityUI.business.transformer.GenericResultTransformer;
import net.kodar.universityUI.data.entities.Student;
import net.kodar.universityUI.presentation.model.result.StudentResult;
import org.springframework.stereotype.Component;

@Component
public class StudentResultTransformer implements
        GenericResultTransformer<Student, StudentResult> {

    @Override
    public StudentResult apply(Student student) {

        StudentResult studentResult = new StudentResult();

        studentResult.setFirstName(student.getFirstName());
        studentResult.setId(student.getId());
        studentResult.setLastName(student.getLastName());

        return studentResult;
    }

}
