package net.kodar.university.presentation.service.student;

import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import net.kodar.university.presentation.service.ServiceGenericImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="student", produces = "application/json", consumes = "application/json")
public class StudentServiceGenericImpl extends ServiceGenericImpl
        <StudentParam,
                StudentResult,
                StudentProcessorGenericImpl> implements StudentServiceGeneric{

    public StudentServiceGenericImpl(){
        this.processor = new StudentProcessorGenericImpl();
    }

    @Override
    protected int getId(StudentParam param) {
        return param.getID();
    }
}
