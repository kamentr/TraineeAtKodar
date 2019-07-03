package net.kodar.university.presentation.service.teacher;

import net.kodar.university.business.processor.teacher.TeacherProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import net.kodar.university.presentation.depricated.result.TeacherResult;
import net.kodar.university.presentation.service.ServiceGenericImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="teacher", produces = "application/json", consumes = "application/json")
public class TeacherServiceGenericImpl extends ServiceGenericImpl
        <TeacherParam,
                TeacherResult,
                TeacherProcessorGenericImpl>
        implements TeacherServiceGeneric {

    public TeacherServiceGenericImpl() {
        this.processor = new TeacherProcessorGenericImpl();
    }

    @Override
    protected int getId(TeacherParam param) {
        return param.getId();
    }
}
