package net.kodar.trainee.business.processor.discipline;

import net.kodar.trainee.business.processor.ProcessorGenericImpl;
import net.kodar.trainee.business.transformer.param.DisciplineParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.DisciplineResultGenericResultTransformer;
import net.kodar.trainee.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoGeneric;
import net.kodar.trainee.presentation.parameter.DisciplineParam;
import net.kodar.trainee.presentation.result.DisciplineResult;

import java.util.List;

public abstract class DisciplineProcessorGeneric extends ProcessorGenericImpl
        <DisciplineParam,
                DisciplineResult,
                Integer,
                Discipline,
                DisciplineDaoGeneric,
                DisciplineParamGenericParamTransformer,
                DisciplineResultGenericResultTransformer,
                DisciplineGenericValidatorImpl> {

    public abstract List<DisciplineResult> getByStudentId(Integer id);

    public abstract List<DisciplineResult> getByTeacherId(Integer id);
}
