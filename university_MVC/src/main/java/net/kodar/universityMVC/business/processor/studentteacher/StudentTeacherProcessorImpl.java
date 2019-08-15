package net.kodar.universityMVC.business.processor.studentteacher;

import net.kodar.universityMVC.business.processor.ProcessorImpl;
import net.kodar.universityMVC.business.transformer.param.StudentTeacherParamTransformer;
import net.kodar.universityMVC.business.transformer.result.StudentTeacherResultTransformer;
import net.kodar.universityMVC.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.StudentTeacher;
import net.kodar.universityMVC.dataaccess.dao.studenteacher.StudentTeacherDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.param.StudentTeacherParam;
import net.kodar.universityMVC.presentation.model.result.StudentTeacherResult;
import org.springframework.stereotype.Service;

@Service
public class StudentTeacherProcessorImpl extends ProcessorImpl
        <StudentTeacherParam,
                StudentTeacherResult,
                Integer,
                StudentTeacher,
                StudentTeacherDaoGenericImpl,
                StudentTeacherParamTransformer,
                StudentTeacherResultTransformer,
                StudentTeacherGenericValidatorImpl>
        implements StudentTeacherProcessor {



    @Override
    public int getID(StudentTeacherParam entity) {
        return entity.getId();
    }
}
