package net.kodar.university.business.processor.studentteacher;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.university.presentation.parameter.StudentTeacherParam;
import net.kodar.university.presentation.result.StudentTeacherResult;

import java.util.List;

public abstract class StudentTeacherProcessorGeneric extends ProcessorGenericImpl
        <StudentTeacherParam,
                StudentTeacherResult,
                Integer,
                StudentTeacher,
                StudentTeacherDaoGeneric,
                StudentTeacherParamGenericParamTransformer,
                StudentTeacherResultGenericResultTransformer,
                StudentTeacherGenericValidatorImpl>{

    public abstract List<StudentTeacherResult> filterByStudent(Integer id);

    public abstract List<StudentTeacherResult> filterByTeacher(Integer id);

    public abstract void deleteStudent(int id);

    public abstract void deleteTeacher(int id);
}
