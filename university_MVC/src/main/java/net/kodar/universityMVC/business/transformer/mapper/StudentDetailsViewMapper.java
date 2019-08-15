package net.kodar.universityMVC.business.transformer.mapper;

import net.kodar.universityMVC.business.processor.discipline.DisciplineProcessor;
import net.kodar.universityMVC.business.processor.student.StudentProcessor;
import net.kodar.universityMVC.business.processor.teacher.TeacherProcessor;
import net.kodar.universityMVC.presentation.model.result.DisciplineResult;
import net.kodar.universityMVC.presentation.model.result.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.result.StudentResult;
import net.kodar.universityMVC.presentation.model.result.TeacherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class StudentDetailsViewMapper implements Mapper{

    private TeacherProcessor teacherService;
    private DisciplineProcessor disciplineService;
    private StudentProcessor studentService;

    @Autowired
    public StudentDetailsViewMapper(TeacherProcessor teacherService, DisciplineProcessor disciplineService, StudentProcessor studentService) {
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.studentService = studentService;
    }


    public void map(ModelAndView modelAndView, Object...args){
        Integer id = (Integer) args[0];

        StudentDetailsView studentDetailsView = new StudentDetailsView();

        List<DisciplineResult> disciplines = disciplineService.getDisciplinesByStudentId(id);
        List<TeacherResult> teachers = teacherService.getTeachersByStudentId(id);
        StudentResult student = studentService.get(id);

        studentDetailsView.setDisciplineList(disciplines);
        studentDetailsView.setTeacherList(teachers);
        studentDetailsView.setStudent(student);

        modelAndView.setViewName("studentdetails");
        modelAndView.addObject("student", studentDetailsView.getStudent());
        modelAndView.addObject("teacherList", studentDetailsView.getTeacherList());
        modelAndView.addObject("disciplineList", studentDetailsView.getDisciplineList());
    }
}
