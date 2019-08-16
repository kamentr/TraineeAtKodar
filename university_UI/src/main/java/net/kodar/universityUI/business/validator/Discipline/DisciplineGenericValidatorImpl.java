package net.kodar.universityUI.business.validator.Discipline;

import net.kodar.universityUI.business.validator.GenericValidatorImpl;
import net.kodar.universityUI.presentation.model.param.DisciplineParam;
import org.springframework.stereotype.Component;

@Component
public class DisciplineGenericValidatorImpl extends GenericValidatorImpl<DisciplineParam> implements DisciplineGenericValidator {

    @Override
    public void validate(DisciplineParam obj){
        super.validate(obj);
    }
}
