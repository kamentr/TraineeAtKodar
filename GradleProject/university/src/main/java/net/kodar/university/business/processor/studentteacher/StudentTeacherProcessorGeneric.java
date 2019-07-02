package net.kodar.university.business.processor.studentteacher;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;

import java.util.List;

public interface StudentTeacherProcessorGeneric extends Processor<StudentTeacherParam, StudentTeacherResult> {

    List<StudentTeacherResult> filterByStudent(Integer id);

    List<StudentTeacherResult> filterByTeacher(Integer id);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
