package net.kodar.university.presentation.service.teacher;

import net.kodar.university.business.processor.teacher.TeacherProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import net.kodar.university.presentation.depricated.result.TeacherResult;
import net.kodar.university.presentation.service.ServiceGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "teacher")
public class TeacherService extends ServiceGeneric
        <TeacherParam,
                TeacherResult,
                TeacherProcessorGenericImpl> {

    @Override
    protected int getId(TeacherParam param) {
        return param.getId();
    }
}
