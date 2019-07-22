package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.Teacher;
import net.kodar.university.presentation.depricated.result.TeacherResult;
import org.springframework.stereotype.Component;

@Component
public class TeacheResultGenericResultTransformer implements
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
