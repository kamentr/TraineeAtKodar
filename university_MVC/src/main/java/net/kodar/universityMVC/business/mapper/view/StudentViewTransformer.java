package net.kodar.universityMVC.business.mapper.view;


import net.kodar.universityMVC.business.mapper.GenericViewTransformer;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.presentation.model.view.StudentView;
import org.springframework.stereotype.Component;

@Component
public class StudentViewTransformer implements
        GenericViewTransformer<Student, StudentView> {


    @Override
    public StudentView apply(Student student) {

        StudentView studentView = new StudentView();

        studentView.setFirstName(student.getFirstName());
        studentView.setId(student.getId());
        studentView.setLastName(student.getLastName());

        return studentView;
    }

}
