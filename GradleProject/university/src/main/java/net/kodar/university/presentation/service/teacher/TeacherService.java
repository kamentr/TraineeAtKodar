//package net.kodar.university.presentation.service.teacher;
//
//
//import net.kodar.university.business.processor.teacher.TeacherProcessorGeneric;
//import net.kodar.university.business.processor.teacher.TeacherProcessorGenericImpl;
//import net.kodar.university.presentation.depricated.result.TeacherResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("teacher")
//public class TeacherService {
//
//    private TeacherProcessorGeneric teacherProcessor = new TeacherProcessorGenericImpl();
//
//    @GetMapping
//    public List<TeacherResult> getAll(){
//        List<TeacherResult> result = teacherProcessor.getAll();
//        return result;
//    }
//
//    @GetMapping("/{id}")
//    public TeacherResult get(@PathVariable(name = "id") int id){
//        TeacherResult teacherResult = teacherProcessor.get(id);
//        return teacherResult;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable(name = "id") int id){
//        teacherProcessor.delete(id);
//    }
//}
