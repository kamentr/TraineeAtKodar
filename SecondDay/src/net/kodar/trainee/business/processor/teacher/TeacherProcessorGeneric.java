package net.kodar.trainee.business.processor.teacher;

import net.kodar.trainee.business.processor.ProcessorGenericImpl;
import net.kodar.trainee.business.transformer.param.TeacherParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.trainee.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.trainee.presentation.parameter.TeacherParam;
import net.kodar.trainee.presentation.result.TeacherResult;

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
