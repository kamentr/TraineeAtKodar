package net.kodar.university.business.processor.teacher;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.transformer.param.TeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.university.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.university.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.university.entities.Teacher;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import net.kodar.university.presentation.depricated.result.TeacherResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherProcessorGenericImpl extends ProcessorGenericImpl
        <TeacherParam,
                TeacherResult,
                Integer,
                Teacher,
                TeacherDaoGenericImpl,
                TeacherParamGenericParamTransformer,
                TeacheResultGenericResultTransformer,
                TeacherGenericValidatorImpl> implements TeacherProcessorGeneric {

    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();

    @Override
    public List<TeacherResult> getTeachersByStudentId(Integer studentId) {
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
