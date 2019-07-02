package net.kodar.university.business.processor.student;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.university.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;

import java.util.List;

public interface StudentProcessorGeneric extends Processor<StudentParam, StudentResult> {

    List<StudentResult> getStudentsByTeacherId(Integer teacherId);

}
