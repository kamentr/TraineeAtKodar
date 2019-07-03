//package net.kodar.university.presentation.service.studentteacherdiscipline;
//
//import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGeneric;
//import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGenericImpl;
//import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("studentteacherdiscipline")
//public class StudentTeacherDisciplineService {
//
//    private StudentTeacherDisciplineProcessorGeneric studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorGenericImpl();
//
//    @GetMapping
//    public List<StudentTeacherDisciplineResult> getAll(){
//        List<StudentTeacherDisciplineResult> studentTeacherDisciplineResultList = studentTeacherDisciplineProcessor.getAll();
//        return studentTeacherDisciplineResultList;
//    }
//
//    @GetMapping("/{id}")
//    public StudentTeacherDisciplineResult get(@PathVariable(name = "id") int id){
//        StudentTeacherDisciplineResult result = studentTeacherDisciplineProcessor.get(id);
//        return result;
//    }
//
//   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable(name = "id") int id){
//        studentTeacherDisciplineProcessor.delete(id);
//    }
//}
//