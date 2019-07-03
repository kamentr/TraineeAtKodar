package net.kodar.university.presentation.service.studentteacher;

import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;
import net.kodar.university.presentation.service.ServiceGenericImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="studentteacher", produces = "application/json", consumes = "application/json")
public class StudentTeacherServiceGenericImpl extends ServiceGenericImpl
        <StudentTeacherParam, StudentTeacherResult, StudentTeacherProcessorGenericImpl>  implements StudentTeacherServiceGeneric{

    public StudentTeacherServiceGenericImpl() {
        this.processor = new StudentTeacherProcessorGenericImpl();
    }

    @Override
    protected int getId(StudentTeacherParam param) {
        return param.getId();
    }
}
