package net.kodar.universityMVC.business.service.teacher;


import net.kodar.universityMVC.business.service.ServiceImpl;
import net.kodar.universityMVC.business.service.studentteacher.StudentTeacherService;
import net.kodar.universityMVC.business.service.studentteacher.StudentTeacherServiceImpl;
import net.kodar.universityMVC.business.mapper.binding.TeacherParamGenericBindingTransformer;
import net.kodar.universityMVC.business.mapper.view.TeacheResultGenericViewTransformer;
import net.kodar.universityMVC.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.binding.TeacherParam;
import net.kodar.universityMVC.presentation.model.view.TeacherView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl extends ServiceImpl
        <TeacherParam,
                TeacherView,
                Integer,
                Teacher,
                TeacherDaoGenericImpl,
                TeacherParamGenericBindingTransformer,
                TeacheResultGenericViewTransformer,
                TeacherGenericValidatorImpl> implements TeacherService {

    private StudentTeacherService studentTeacherProcessor = new StudentTeacherServiceImpl();

    @Override
    public List<TeacherView> getTeachersByStudentId(Integer studentId) {
        return this.dao.getTeachersByStudentId(studentId)
                .stream()
                .map(t -> this.rtr.apply(t))
                .collect(Collectors.toList());
    }

    @Override
    public int getID(TeacherParam entity) {
        return entity.getId();
    }
}
