package net.kodar.universityMVC.business.transformer.result;

import net.kodar.universityMVC.business.transformer.GenericResultTransformer;
import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.presentation.model.result.TeacherResult;
import org.springframework.stereotype.Component;

@Component
public class TeacherResultTransformer implements
        GenericResultTransformer<Teacher, TeacherResult> {

    @Override
    public TeacherResult apply(Teacher Teacher) {
        TeacherResult teacherResult = new TeacherResult();
        teacherResult.setFirstName(Teacher.getFirstName());
        teacherResult.setLastName(Teacher.getLastName());
        teacherResult.setId(Teacher.getId());

        return teacherResult;
    }

}
