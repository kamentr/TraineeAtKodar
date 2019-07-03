package net.kodar.university.presentation.service.studentteacherdiscipline;

import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherDisciplineParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;
import net.kodar.university.presentation.service.ServiceGenericImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="studentteacherdiscipline", produces = "application/json", consumes = "application/json")
public class StudentTeacherDisciplineServiceGenericImpl extends ServiceGenericImpl
        <StudentTeacherDisciplineParam,
                StudentTeacherDisciplineResult,
                StudentTeacherDisciplineProcessorGenericImpl>
        implements StudentTeacherDisciplineServiceGeneric {

    public StudentTeacherDisciplineServiceGenericImpl() {
        this.processor = new StudentTeacherDisciplineProcessorGenericImpl();
    }

    @Override
    protected int getId(StudentTeacherDisciplineParam param) {
        return param.getId();
    }
}
