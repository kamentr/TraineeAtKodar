package net.kodar.university.business.processor.studentteacherdiscipline;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacherDiscipline;
import net.kodar.university.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherDisciplineParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;

import java.util.List;

public interface StudentTeacherDisciplineProcessorGeneric extends Processor<StudentTeacherDisciplineParam, StudentTeacherDisciplineResult> {

    List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId);

    List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId);

    void deleteStudent(int id);

    void deleteTeacher(int id);
}
