package net.kodar.university.presentation.service.student;

import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import net.kodar.university.presentation.service.ServiceGeneric;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentService extends ServiceGeneric
        <StudentParam,
                StudentResult,
                StudentProcessorGenericImpl> {

    @Override
    protected int getId(StudentParam param) {
        return param.getId();
    }

    @RequestMapping(value = "/byteacher/{id}", produces = "application/json")
    public List<StudentResult> byTeacher(@PathVariable(value = "id") Integer id){
        return this.processor.getStudentsByTeacherId(id);
    }

}
