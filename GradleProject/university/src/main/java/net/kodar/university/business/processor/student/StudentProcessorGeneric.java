package net.kodar.university.business.processor.student;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.university.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.presentation.parameter.StudentParam;
import net.kodar.university.presentation.result.StudentResult;

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
