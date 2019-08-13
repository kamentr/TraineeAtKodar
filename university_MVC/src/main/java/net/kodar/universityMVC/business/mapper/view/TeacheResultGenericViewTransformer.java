package net.kodar.universityMVC.business.mapper.view;

import net.kodar.universityMVC.business.mapper.GenericViewTransformer;
import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.presentation.model.view.TeacherView;
import org.springframework.stereotype.Component;

@Component
public class TeacheResultGenericViewTransformer implements
        GenericViewTransformer<Teacher, TeacherView> {

    @Override
    public TeacherView apply(Teacher Teacher) {
        TeacherView teacherView = new TeacherView();
        teacherView.setFirstName(Teacher.getFirstName());
        teacherView.setLastName(Teacher.getLastName());
        teacherView.setId(Teacher.getId());

        return teacherView;
    }

}
