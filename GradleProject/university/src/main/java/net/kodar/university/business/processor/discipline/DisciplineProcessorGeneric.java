package net.kodar.university.business.processor.discipline;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.DisciplineParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.DisciplineResultGenericResultTransformer;
import net.kodar.university.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.university.data.entities.Discipline;
import net.kodar.university.dataaccess.dao.discipline.DisciplineDaoGeneric;
import net.kodar.university.presentation.parameter.DisciplineParam;
import net.kodar.university.presentation.result.DisciplineResult;


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
