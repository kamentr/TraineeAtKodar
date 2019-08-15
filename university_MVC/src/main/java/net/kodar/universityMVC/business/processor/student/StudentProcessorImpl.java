package net.kodar.universityMVC.business.processor.student;

import net.kodar.universityMVC.business.transformer.param.StudentParamTransformer;
import net.kodar.universityMVC.business.transformer.mapper.StudentDetailsViewConverter;
import net.kodar.universityMVC.business.transformer.result.StudentResultTransformer;
import net.kodar.universityMVC.business.processor.ProcessorImpl;
import net.kodar.universityMVC.business.processor.discipline.DisciplineProcessor;
import net.kodar.universityMVC.business.processor.teacher.TeacherProcessor;
import net.kodar.universityMVC.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.Student;
import net.kodar.universityMVC.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.param.StudentParam;
import net.kodar.universityMVC.presentation.model.result.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.result.StudentResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentProcessorImpl extends ProcessorImpl
        <StudentParam, StudentResult, Integer, Student,
                StudentDaoGenericImpl,
                StudentParamTransformer,
                StudentResultTransformer,
                StudentGenericValidatorImpl>
        implements StudentProcessor {

    private ModelMapper modelMapper;

    @Autowired
    public StudentProcessorImpl(ModelMapper modelMapper, DisciplineProcessor disciplineService, TeacherProcessor teacherService) {
        this.modelMapper = modelMapper;
        this.modelMapper.addConverter(new StudentDetailsViewConverter(teacherService, disciplineService, this));
    }

    @Override
    public int getID(StudentParam entity) {
        return entity.getId();
    }

    @Override
    public List<StudentResult> getStudentsByTeacherId(Integer teacherId) {
        return dao.getStudentsByTeacherId(teacherId).stream().map(this.rtr).collect(Collectors.toList());
    }

    @Override
    public StudentDetailsView getDetailsByStudentId(Integer studentId) {
        StudentDetailsView studentDetailsView = modelMapper.map(studentId, StudentDetailsView.class);
        return studentDetailsView;
    }
}
