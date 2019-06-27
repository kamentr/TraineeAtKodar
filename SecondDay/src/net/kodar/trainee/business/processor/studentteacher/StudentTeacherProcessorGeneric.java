package net.kodar.trainee.business.processor.studentteacher;

import net.kodar.trainee.business.processor.ProcessorGenericImpl;
import net.kodar.trainee.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.trainee.presentation.parameter.StudentTeacherParam;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

import java.util.List;

public abstract class StudentTeacherProcessorGeneric extends ProcessorGenericImpl
        <StudentTeacherParam,
                StudentTeacherResult,
                Integer,
                StudentTeacher,
                StudentTeacherDaoGeneric,
                StudentTeacherParamGenericParamTransformer,
                StudentTeacherResultGenericResultTransformer>{

    abstract List<StudentTeacherResult> filterByStudent(Integer id);

    abstract List<StudentTeacherResult> filterByTeacher(Integer id);

    public abstract void deleteStudent(int id);

    public abstract void deleteTeacher(int id);
}
