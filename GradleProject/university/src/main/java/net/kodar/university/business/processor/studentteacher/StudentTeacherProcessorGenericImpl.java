package net.kodar.university.business.processor.studentteacher;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherProcessorGenericImpl extends ProcessorGenericImpl
        <StudentTeacherParam,
                StudentTeacherResult,
                Integer,
                StudentTeacher,
                StudentTeacherDaoGeneric,
                StudentTeacherParamGenericParamTransformer,
                StudentTeacherResultGenericResultTransformer,
                StudentTeacherGenericValidatorImpl>
        implements StudentTeacherProcessorGeneric {



    @Override
    public int getID(StudentTeacherParam entity) {
        return entity.getId();
    }
}
