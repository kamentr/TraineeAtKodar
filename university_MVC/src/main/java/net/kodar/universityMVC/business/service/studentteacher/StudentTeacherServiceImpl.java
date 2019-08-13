package net.kodar.universityMVC.business.service.studentteacher;

import net.kodar.universityMVC.business.service.ServiceImpl;
import net.kodar.universityMVC.business.mapper.binding.StudentTeacherParamGenericBindingTransformer;
import net.kodar.universityMVC.business.mapper.view.StudentTeacherResultGenericViewTransformer;
import net.kodar.universityMVC.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.StudentTeacher;
import net.kodar.universityMVC.dataaccess.dao.studenteacher.StudentTeacherDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherParam;
import net.kodar.universityMVC.presentation.model.view.StudentTeacherResult;
import org.springframework.stereotype.Service;

@Service
public class StudentTeacherServiceImpl extends ServiceImpl
        <StudentTeacherParam,
                StudentTeacherResult,
                Integer,
                StudentTeacher,
                StudentTeacherDaoGenericImpl,
                StudentTeacherParamGenericBindingTransformer,
                StudentTeacherResultGenericViewTransformer,
                StudentTeacherGenericValidatorImpl>
        implements StudentTeacherService {



    @Override
    public int getID(StudentTeacherParam entity) {
        return entity.getId();
    }
}
