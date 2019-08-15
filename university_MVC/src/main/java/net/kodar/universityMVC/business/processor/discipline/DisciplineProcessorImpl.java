package net.kodar.universityMVC.business.processor.discipline;

import net.kodar.universityMVC.business.processor.ProcessorImpl;
import net.kodar.universityMVC.business.transformer.param.DisciplineParamTransformer;
import net.kodar.universityMVC.business.transformer.result.DisciplineResultTransformer;
import net.kodar.universityMVC.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.param.DisciplineParam;
import net.kodar.universityMVC.presentation.model.result.DisciplineResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DisciplineProcessorImpl extends ProcessorImpl
        <DisciplineParam, DisciplineResult, Integer, Discipline,
                DisciplineDaoGenericImpl,
                DisciplineParamTransformer,
                DisciplineResultTransformer,
                DisciplineGenericValidatorImpl>
        implements DisciplineProcessor
{
    @Override
    public int getID(DisciplineParam entity) {
        return entity.getId();
    }

    @Override
    public List<DisciplineResult> getDisciplinesByStudentId(int studentId) {
        return this.dao.getDisciplinesByStudentId(studentId).stream().map(this.rtr).collect(Collectors.toList());
    }
}
