package net.kodar.universityUI.business.processor.discipline;


import net.kodar.universityUI.business.processor.ProcessorImpl;
import net.kodar.universityUI.business.transformer.param.DisciplineParamTransformer;
import net.kodar.universityUI.business.transformer.result.DisciplineResultTransformer;
import net.kodar.universityUI.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.universityUI.data.entities.Discipline;
import net.kodar.universityUI.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.universityUI.presentation.model.param.DisciplineParam;
import net.kodar.universityUI.presentation.model.result.DisciplineResult;
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
