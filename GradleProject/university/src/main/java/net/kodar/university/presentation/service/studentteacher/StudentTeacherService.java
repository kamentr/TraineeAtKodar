package net.kodar.university.presentation.service.studentteacher;

import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;
import net.kodar.university.presentation.service.ServiceGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="studentteacher")
public class StudentTeacherService extends ServiceGeneric
        <StudentTeacherParam,
                StudentTeacherResult,
                StudentTeacherProcessorGenericImpl>{

    @Override
    protected int getId(StudentTeacherParam param) {
        return param.getId();
    }
}
