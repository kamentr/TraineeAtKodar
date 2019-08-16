package net.kodar.universityUI.business.processor.studentteacher;


import net.kodar.universityUI.business.processor.ProcessorImpl;
import net.kodar.universityUI.business.transformer.param.StudentTeacherParamTransformer;
import net.kodar.universityUI.business.transformer.result.StudentTeacherResultTransformer;
import net.kodar.universityUI.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.universityUI.data.entities.StudentTeacher;
import net.kodar.universityUI.dataaccess.dao.studenteacher.StudentTeacherDaoGenericImpl;
import net.kodar.universityUI.presentation.model.param.StudentTeacherParam;
import net.kodar.universityUI.presentation.model.result.StudentTeacherResult;
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
