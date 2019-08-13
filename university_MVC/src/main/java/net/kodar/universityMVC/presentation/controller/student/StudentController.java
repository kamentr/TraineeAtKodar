package net.kodar.universityMVC.presentation.controller.student;

import net.kodar.universityMVC.business.service.student.StudentService;
import net.kodar.universityMVC.presentation.model.binding.StudentBinding;
import net.kodar.universityMVC.presentation.model.view.StudentDetailsView;
import net.kodar.universityMVC.presentation.model.view.StudentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("form")
    public String saveform(Model student) {

        student.addAttribute("student", new StudentBinding());

        return "studentform";
    }

    @PostMapping("form")
    public String save(@Valid @ModelAttribute("student") StudentBinding student, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "studentform";
        }

        service.save(student);

        model.addAttribute("student", student);

        return "studentsave";
    }

    @RequestMapping("view")
    public ModelAndView showStudents(ModelAndView modelAndView) {

        List<StudentView> list = service.getAll();

        modelAndView.setViewName("studentview");
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @RequestMapping("details/{id}")
    public ModelAndView details(@PathVariable(name = "id") int id, ModelAndView modelAndView) {

        StudentDetailsView studentDetailsView = service.getDetailsByStudentId(id); //modelMapper.map(id, StudentDetailsView.class);

        modelAndView.setViewName("studentdetails");
        modelAndView.addObject("student", studentDetailsView.getStudent());
        modelAndView.addObject("teacherList", studentDetailsView.getTeacherList());
        modelAndView.addObject("disciplineList", studentDetailsView.getDisciplineList());

        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/student/view";
    }

    @GetMapping(value = "update/{id}")
    public String updateform(Model student){

        student.addAttribute("student", new StudentBinding());

        return "studentupdateform";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("student") StudentBinding student, Model model){

        student.setId(id);
        service.update(student);

        model.addAttribute("student", student);

        return "studentupdateresult";
    }
}
