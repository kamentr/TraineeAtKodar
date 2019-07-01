package net.kodar.university.business.processor.teacher;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.TeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.university.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.university.data.entities.Teacher;
import net.kodar.university.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.university.presentation.parameter.TeacherParam;
import net.kodar.university.presentation.result.TeacherResult;

import java.util.List;

public abstract class TeacherProcessorGeneric extends ProcessorGenericImpl
        <TeacherParam,
                TeacherResult,
                Integer,
                Teacher,
                TeacherDaoGenericImpl,
                TeacherParamGenericParamTransformer,
                TeacheResultGenericResultTransformer,
                TeacherGenericValidatorImpl> {

    public abstract List<TeacherResult> getTeachersByStudentId(Integer studentId);
}
