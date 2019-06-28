package net.kodar.trainee.business.processor.studentteacherdiscipline;

import net.kodar.trainee.business.processor.ProcessorGenericImpl;
import net.kodar.trainee.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.trainee.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidatorImpl;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

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
