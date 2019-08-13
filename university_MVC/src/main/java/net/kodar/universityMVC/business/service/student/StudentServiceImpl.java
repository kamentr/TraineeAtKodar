package net.kodar.universityMVC.business.service.student;

import net.kodar.universityMVC.business.mapper.binding.StudentBindingTransformer;
import net.kodar.universityMVC.business.mapper.converter.StudentDetailsViewConverter;
import net.kodar.universityMVC.business.mapper.view.StudentViewTransformer;
import net.kodar.universityMVC.business.service.ServiceImpl;
import net.kodar.universityMVC.business.service.discipline.DisciplineService;
import net.kodar.universityMVC.business.service.teacher.TeacherService;
import net.kodar.universityMVC.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.binding.StudentBinding;
import net.kodar.universityMVC.presentation.model.view.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.view.StudentView;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends ServiceImpl
        <StudentBinding, StudentView, Integer, Student,
                StudentDaoGenericImpl,
                StudentBindingTransformer,
                StudentViewTransformer,
                StudentGenericValidatorImpl>
        implements StudentService {

    private ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(ModelMapper modelMapper, DisciplineService disciplineService, TeacherService teacherService) {
        this.modelMapper = modelMapper;
        this.modelMapper.addConverter(new StudentDetailsViewConverter(teacherService, disciplineService, this));
    }

    @Override
    public int getID(StudentBinding entity) {
        return entity.getId();
    }

    @Override
    public List<StudentView> getStudentsByTeacherId(Integer teacherId) {
        return dao.getStudentsByTeacherId(teacherId).stream().map(this.rtr).collect(Collectors.toList());
    }

    @Override
    public StudentDetailsView getDetailsByStudentId(Integer studentId) {
        StudentDetailsView studentDetailsView = modelMapper.map(studentId, StudentDetailsView.class);
        return studentDetailsView;
    }
}
