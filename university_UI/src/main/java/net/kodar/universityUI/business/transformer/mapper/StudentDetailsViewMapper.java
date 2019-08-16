package net.kodar.universityUI.business.transformer.mapper;


import net.kodar.universityUI.business.processor.discipline.DisciplineProcessor;
import net.kodar.universityUI.business.processor.student.StudentProcessor;
import net.kodar.universityUI.business.processor.teacher.TeacherProcessor;
import net.kodar.universityUI.presentation.model.result.DisciplineResult;
import net.kodar.universityUI.presentation.model.result.StudentDetailsView;
import net.kodar.universityUI.presentation.model.result.StudentResult;
import net.kodar.universityUI.presentation.model.result.TeacherResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class StudentDetailsViewMapper implements Mapper{

    private TeacherProcessor teacherProcessor;
    private DisciplineProcessor disciplineProcessor;
    private StudentProcessor studentProcessor;

    @Autowired
    public StudentDetailsViewMapper(TeacherProcessor teacherProcessor, DisciplineProcessor disciplineProcessor, StudentProcessor studentProcessor) {
        this.teacherProcessor = teacherProcessor;
        this.disciplineProcessor = disciplineProcessor;
        this.studentProcessor = studentProcessor;
    }


    public void map(ModelAndView modelAndView, Object...args){
        Integer id = (Integer) args[0];

        StudentDetailsView studentDetailsView = new StudentDetailsView();

        List<DisciplineResult> disciplines = disciplineProcessor.getDisciplinesByStudentId(id);
        List<TeacherResult> teachers = teacherProcessor.getTeachersByStudentId(id);
        StudentResult student = studentProcessor.get(id);

        studentDetailsView.setDisciplineList(disciplines);
        studentDetailsView.setTeacherList(teachers);
        studentDetailsView.setStudent(student);

        modelAndView.setViewName("studentdetails");
        modelAndView.addObject("student", studentDetailsView.getStudent());
        modelAndView.addObject("teacherList", studentDetailsView.getTeacherList());
        modelAndView.addObject("disciplineList", studentDetailsView.getDisciplineList());
    }
}
