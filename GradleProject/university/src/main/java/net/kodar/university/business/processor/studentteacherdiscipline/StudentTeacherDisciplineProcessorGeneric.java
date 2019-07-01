package net.kodar.university.business.processor.studentteacherdiscipline;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacherDiscipline;
import net.kodar.university.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.university.presentation.parameter.StudentTeacherDisciplineParam;
import net.kodar.university.presentation.result.StudentTeacherDisciplineResult;

import java.util.List;

public abstract class StudentTeacherDisciplineProcessorGeneric extends ProcessorGenericImpl
        <StudentTeacherDisciplineParam,
                StudentTeacherDisciplineResult,
                Integer,
                StudentTeacherDiscipline,
                StudentTeacherDisciplineDaoGeneric,
                StudentTeacherDisciplineParamGenericParamTransformer,
                StudentTeacherDisciplineResultGenericResultTransformer,
                StudentTeacherDisciplineGenericValidatorImpl> {

    public abstract List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId);

    abstract List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId);

    abstract void deleteStudent(int id);

    abstract void deleteTeacher(int id);
}
