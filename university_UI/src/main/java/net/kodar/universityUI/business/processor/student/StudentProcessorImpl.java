package net.kodar.universityUI.business.processor.student;

import net.kodar.universityUI.business.processor.ProcessorImpl;
import net.kodar.universityUI.business.transformer.param.StudentParamTransformer;
import net.kodar.universityUI.business.transformer.result.StudentResultTransformer;
import net.kodar.universityUI.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.universityUI.data.entities.Student;
import net.kodar.universityUI.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.universityUI.presentation.model.param.StudentParam;
import net.kodar.universityUI.presentation.model.result.StudentResult;
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


    @Override
    public int getID(StudentParam entity) {
        return entity.getId();
    }

    @Override
    public List<StudentResult> getStudentsByTeacherId(Integer teacherId) {
        return dao.getStudentsByTeacherId(teacherId).stream().map(this.rtr).collect(Collectors.toList());
    }

}
