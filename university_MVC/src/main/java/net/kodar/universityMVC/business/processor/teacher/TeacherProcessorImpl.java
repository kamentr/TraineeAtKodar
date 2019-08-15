package net.kodar.universityMVC.business.processor.teacher;


import net.kodar.universityMVC.business.processor.ProcessorImpl;
import net.kodar.universityMVC.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.universityMVC.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.universityMVC.business.transformer.param.TeacherParamTransformer;
import net.kodar.universityMVC.business.transformer.result.TeacherResultTransformer;
import net.kodar.universityMVC.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.param.TeacherParam;
import net.kodar.universityMVC.presentation.model.result.TeacherResult;
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
