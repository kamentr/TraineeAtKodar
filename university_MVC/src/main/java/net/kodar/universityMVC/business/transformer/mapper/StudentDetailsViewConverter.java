package net.kodar.universityMVC.business.transformer.mapper;

import net.kodar.universityMVC.business.processor.discipline.DisciplineProcessor;
import net.kodar.universityMVC.business.processor.student.StudentProcessor;
import net.kodar.universityMVC.business.processor.teacher.TeacherProcessor;
import net.kodar.universityMVC.presentation.model.result.DisciplineResult;
import net.kodar.universityMVC.presentation.model.result.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.result.StudentResult;
import net.kodar.universityMVC.presentation.model.result.TeacherResult;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDetailsViewConverter implements Converter<Integer, StudentDetailsView> {

    private TeacherProcessor teacherService;
    private DisciplineProcessor disciplineService;
    private StudentProcessor studentService;

    private StudentDetailsView studentDetailsView;

    @Autowired
    public StudentDetailsViewConverter(TeacherProcessor teacherService, DisciplineProcessor disciplineService, StudentProcessor studentService) {
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.studentService = studentService;
    }

    @Override
    public StudentDetailsView convert(MappingContext<Integer, StudentDetailsView> context) {

        Integer id = context.getSource();

        studentDetailsView = new StudentDetailsView();

        List<DisciplineResult> disciplines = disciplineService.getDisciplinesByStudentId(id);
        List<TeacherResult> teachers = teacherService.getTeachersByStudentId(id);
        StudentResult student = studentService.get(id);

        studentDetailsView.setDisciplineList(disciplines);
        studentDetailsView.setTeacherList(teachers);
        studentDetailsView.setStudent(student);

        return studentDetailsView;
    }
}
