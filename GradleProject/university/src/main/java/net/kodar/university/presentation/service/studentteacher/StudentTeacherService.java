package net.kodar.university.presentation.service.studentteacher;

import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentteacher")
public class StudentTeacherService {

    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();

    @GetMapping
    public List<StudentTeacherResult> getAll() {
        return studentTeacherProcessor.getAll();
    }

    @GetMapping("/{id}")
    public StudentTeacherResult get(@PathVariable(name="id") int id) {
        return studentTeacherProcessor.get(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") int id) {
        studentTeacherProcessor.delete(id);
    }
}
