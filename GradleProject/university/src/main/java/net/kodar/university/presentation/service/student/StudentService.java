package net.kodar.university.presentation.service.student;

import net.kodar.university.business.processor.student.StudentProcessorGeneric;
import net.kodar.university.business.processor.student.StudentProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="student", produces = "application/json", consumes = "application/json")
public class StudentService {

    private StudentProcessorGeneric studentProcessor = new StudentProcessorGenericImpl();

    @GetMapping
    public List<StudentResult> getAll() {
        return studentProcessor.getAll();
    }

    @GetMapping("/{id}")
    public StudentResult get(@PathVariable(name="id") int id) {
        return studentProcessor.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable(name="id") int id) {
        studentProcessor.delete(id);
    }

    @PostMapping
    public StudentResult save(@RequestBody StudentParam studentParam){
        StudentResult result= studentProcessor.save(studentParam);
        return result;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable(name="id") int id, @RequestBody StudentParam studentParam){
        studentProcessor.update(studentParam);
    }
}
