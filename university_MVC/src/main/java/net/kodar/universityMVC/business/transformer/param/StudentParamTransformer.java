package net.kodar.universityMVC.business.transformer.param;

import net.kodar.universityMVC.business.transformer.GenericParamTransformer;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.presentation.model.param.StudentParam;
import org.springframework.stereotype.Component;

@Component
public class StudentParamTransformer implements
        GenericParamTransformer<StudentParam, Student, Student> {

    @Override
    public Student apply(StudentParam studentParam, Student student) {

        if (student == null) {
            student = new Student();
            student.setId(studentParam.getId());
        }
        student.setFirstName(studentParam.getFirstName());
        student.setLastName(studentParam.getLastName());

        return student;
    }
}
