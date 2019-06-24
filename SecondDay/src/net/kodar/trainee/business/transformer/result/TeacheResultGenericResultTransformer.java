package net.kodar.trainee.business.transformer.result;

import net.kodar.trainee.business.transformer.GenericResultTransformer;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.presentation.result.TeacherResult;


public class TeacheResultGenericResultTransformer implements
        GenericResultTransformer<Teacher, TeacherResult> {

    @Override
    public TeacherResult apply(Teacher Teacher) {
        TeacherResult teacherResult = new TeacherResult();
        teacherResult.setfName(Teacher.getfName());
        teacherResult.setlName(Teacher.getlName());
        teacherResult.setId(Teacher.getId());

        return teacherResult;
    }

}
