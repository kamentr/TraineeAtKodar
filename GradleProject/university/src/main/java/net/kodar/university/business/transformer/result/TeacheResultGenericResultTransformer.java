package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.Teacher;
import net.kodar.university.presentation.result.TeacherResult;


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
