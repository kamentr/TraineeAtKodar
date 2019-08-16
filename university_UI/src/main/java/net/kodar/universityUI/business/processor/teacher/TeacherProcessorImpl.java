package net.kodar.universityUI.business.processor.teacher;


import net.kodar.universityUI.business.processor.ProcessorImpl;
import net.kodar.universityUI.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.universityUI.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.universityUI.business.transformer.param.TeacherParamTransformer;
import net.kodar.universityUI.business.transformer.result.TeacherResultTransformer;
import net.kodar.universityUI.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.universityUI.data.entities.Teacher;
import net.kodar.universityUI.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.universityUI.presentation.model.param.TeacherParam;
import net.kodar.universityUI.presentation.model.result.TeacherResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherProcessorImpl extends ProcessorImpl
        <TeacherParam,
                TeacherResult,
                Integer,
                Teacher,
                TeacherDaoGenericImpl,
                TeacherParamTransformer,
                TeacherResultTransformer,
                TeacherGenericValidatorImpl> implements TeacherProcessor {

    private StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();

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
