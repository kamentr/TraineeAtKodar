package net.kodar.universityUI.presentation.controller.student;

import net.kodar.universityUI.business.processor.student.StudentProcessor;
import net.kodar.universityUI.business.transformer.mapper.Mapper;
import net.kodar.universityUI.business.transformer.mapper.StudentDetailsViewMapper;
import net.kodar.universityUI.presentation.model.param.StudentParam;
import net.kodar.universityUI.presentation.model.result.StudentResult;
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

    private StudentProcessor processor;

    @Autowired
    private Mapper studentDetailsViewMapper;

    @Autowired
    public StudentController(StudentProcessor processor, StudentDetailsViewMapper studentDetailsViewMapper) {
        this.processor = processor;
        this.studentDetailsViewMapper = studentDetailsViewMapper;
    }

    @GetMapping("form")
    public String saveform(Model student) {

        student.addAttribute("student", new StudentParam());

        return "studentform";
    }

    @PostMapping("form")
    public String save(@Valid @ModelAttribute("student") StudentParam student, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "studentform";
        }

        processor.save(student);

        model.addAttribute("student", student);

        return "studentsave";
    }

    @RequestMapping("view")
    public ModelAndView showStudents(ModelAndView modelAndView) {

        List<StudentResult> list = processor.getAll();

        modelAndView.setViewName("studentview");
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @RequestMapping("details/{id}")
    public ModelAndView details(@PathVariable(name = "id") int id, ModelAndView modelAndView) {

        studentDetailsViewMapper.map(modelAndView, id);

        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        processor.delete(id);
        return "redirect:/student/view";
    }

    @GetMapping(value = "update/{id}")
    public String updateform(Model student){

        student.addAttribute("student", new StudentParam());

        return "studentupdateform";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("student") StudentParam student, Model model){

        student.setId(id);
        processor.update(student);

        model.addAttribute("student", student);

        return "studentupdateresult";
    }
}

