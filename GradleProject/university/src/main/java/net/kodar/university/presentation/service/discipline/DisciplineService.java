//package net.kodar.university.presentation.service.discipline;
//
//
//import net.kodar.university.business.processor.discipline.DisciplineProcessorGeneric;
//import net.kodar.university.business.processor.discipline.DisciplineProcessorGenericImpl;
//import net.kodar.university.presentation.depricated.result.DisciplineResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("discipline")
//public class DisciplineService {
//
//    private DisciplineProcessorGeneric disciplineProcessor = new DisciplineProcessorGenericImpl();
//
//    @GetMapping
//    public List<DisciplineResult> getAll() {
//        return disciplineProcessor.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public DisciplineResult get(@PathVariable(name="id") int id) {
//        return disciplineProcessor.get(id);
//    }
//
//    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
//    public void delete(@PathVariable(name="id") int id) {
//        disciplineProcessor.delete(id);
//    }
//}
