package net.kodar.universityMVC.business.mapper.converter;

import net.kodar.universityMVC.business.service.discipline.DisciplineService;
import net.kodar.universityMVC.business.service.student.StudentService;
import net.kodar.universityMVC.business.service.teacher.TeacherService;
import net.kodar.universityMVC.presentation.model.view.DisciplineView;
import net.kodar.universityMVC.presentation.model.view.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.view.StudentView;
import net.kodar.universityMVC.presentation.model.view.TeacherView;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDetailsViewConverter implements Converter<Integer, StudentDetailsView> {

    private TeacherService teacherService;
    private DisciplineService disciplineService;
    private StudentService studentService;

    private StudentDetailsView studentDetailsView;

    @Autowired
    public StudentDetailsViewConverter(TeacherService teacherService, DisciplineService disciplineService, StudentService studentService) {
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.studentService = studentService;
    }

    @Override
    public StudentDetailsView convert(MappingContext<Integer, StudentDetailsView> context) {

        Integer id = context.getSource();

        studentDetailsView = new StudentDetailsView();

        List<DisciplineView> disciplines = disciplineService.getDisciplinesByStudentId(id);
        List<TeacherView> teachers = teacherService.getTeachersByStudentId(id);
        StudentView student = studentService.get(id);

        studentDetailsView.setDisciplineList(disciplines);
        studentDetailsView.setTeacherList(teachers);
        studentDetailsView.setStudent(student);

        return studentDetailsView;
    }
}
