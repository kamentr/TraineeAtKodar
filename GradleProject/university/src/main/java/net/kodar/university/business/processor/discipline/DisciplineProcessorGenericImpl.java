package net.kodar.university.business.processor.discipline;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.DisciplineParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.DisciplineResultGenericResultTransformer;
import net.kodar.university.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.university.data.entities.Discipline;
import net.kodar.university.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import net.kodar.university.presentation.depricated.result.DisciplineResult;
import org.springframework.stereotype.Component;

@Component
public class DisciplineProcessorGenericImpl extends ProcessorGenericImpl
        <DisciplineParam, DisciplineResult, Integer, Discipline,
                DisciplineDaoGenericImpl,
                DisciplineParamGenericParamTransformer,
                DisciplineResultGenericResultTransformer,
                DisciplineGenericValidatorImpl>
        implements DisciplineProcessorGeneric
{
    @Override
    public int getID(DisciplineParam entity) {
        return entity.getId();
    }
}
