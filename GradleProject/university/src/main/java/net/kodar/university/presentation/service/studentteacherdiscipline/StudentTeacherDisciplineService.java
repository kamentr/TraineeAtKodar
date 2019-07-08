package net.kodar.university.presentation.service.studentteacherdiscipline;

import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherDisciplineParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;
import net.kodar.university.presentation.service.ServiceGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "studentteacherdiscipline")
public class StudentTeacherDisciplineService extends ServiceGeneric
        <StudentTeacherDisciplineParam,
                StudentTeacherDisciplineResult,
                StudentTeacherDisciplineProcessorGenericImpl> {

    @Override
    protected int getId(StudentTeacherDisciplineParam param) {
        return param.getId();
    }
}
