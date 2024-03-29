package net.kodar.university.business.validator.Discipline;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import org.springframework.stereotype.Component;

@Component
public class DisciplineGenericValidatorImpl extends GenericValidatorImpl<DisciplineParam> implements DisciplineGenericValidator {

    @Override
    public void validate(DisciplineParam obj){
        super.validate(obj);
    }
}
