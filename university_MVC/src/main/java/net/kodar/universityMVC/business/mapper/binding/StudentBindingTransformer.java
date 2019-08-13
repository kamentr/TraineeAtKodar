package net.kodar.universityMVC.business.mapper.binding;

import net.kodar.universityMVC.business.mapper.GenericBindingTransformer;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.presentation.model.binding.StudentBinding;
import org.springframework.stereotype.Component;

@Component
public class StudentBindingTransformer implements
        GenericBindingTransformer<StudentBinding, Student, Student> {

    @Override
    public Student apply(StudentBinding studentBinding, Student student) {

        if (student == null) {
            student = new Student();
            student.setId(studentBinding.getId());
        }
        student.setFirstName(studentBinding.getFirstName());
        student.setLastName(studentBinding.getLastName());

        return student;
    }
}
