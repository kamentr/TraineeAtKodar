package net.kodar.university.presentation.service.discipline;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.business.processor.discipline.DisciplineProcessorGenericImpl;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import net.kodar.university.presentation.depricated.result.DisciplineResult;
import net.kodar.university.presentation.service.ServiceGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "discipline", produces = "application/json", consumes = "application/json")
public class DisciplineService extends ServiceGeneric
        <DisciplineParam,
                DisciplineResult,
                DisciplineProcessorGenericImpl> {

    public DisciplineService() {
        this.processor = new DisciplineProcessorGenericImpl();
    }

    @Override
    protected int getId(DisciplineParam param) {
        return param.getId();
    }
}
