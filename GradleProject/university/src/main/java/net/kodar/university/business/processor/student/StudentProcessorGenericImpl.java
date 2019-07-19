package net.kodar.university.business.processor.student;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.university.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentProcessorGenericImpl extends ProcessorGenericImpl
        <StudentParam, StudentResult, Integer, Student,
                StudentDaoGenericImpl,
                StudentParamGenericParamTransformer,
                StudentResultGenericResultTransformer,
                StudentGenericValidatorImpl>
        implements StudentProcessorGeneric {

    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();

    @Override
    public int getID(StudentParam entity) {
        return entity.getId();
    }

    @Override
    public List<StudentResult> getStudentsByTeacherId(Integer teacherId) {
        List<Student> studentsById = this.dao.getStudentById(teacherId);
        return studentsById
                .stream()
                .map(student -> this.rtr.apply(student))
                .collect(Collectors.toList());
    }

}
