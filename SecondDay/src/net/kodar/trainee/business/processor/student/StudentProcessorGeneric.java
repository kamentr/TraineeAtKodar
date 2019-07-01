package net.kodar.trainee.business.processor.student;

import net.kodar.trainee.business.processor.ProcessorGenericImpl;
import net.kodar.trainee.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.trainee.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.trainee.presentation.parameter.StudentParam;
import net.kodar.trainee.presentation.result.StudentResult;

import java.util.List;

public abstract class StudentProcessorGeneric extends ProcessorGenericImpl
        <StudentParam,
                StudentResult,
                Integer,
                Student,
                StudentDaoGenericImpl,
                StudentParamGenericParamTransformer,
                StudentResultGenericResultTransformer,
                StudentGenericValidatorImpl> {

    public abstract List<StudentResult> getStudentsByTeacherId(Integer teacherId);

}
