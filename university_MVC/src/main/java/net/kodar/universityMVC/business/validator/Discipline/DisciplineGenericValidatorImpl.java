package net.kodar.universityMVC.business.validator.Discipline;

import net.kodar.universityMVC.business.validator.GenericValidatorImpl;
import net.kodar.universityMVC.presentation.model.binding.DisciplineParam;
import org.springframework.stereotype.Component;

@Component
public class DisciplineGenericValidatorImpl extends GenericValidatorImpl<DisciplineParam> implements net.kodar.universityMVC.business.validator.Discipline.DisciplineGenericValidator {

    @Override
    public void validate(DisciplineParam obj){
        super.validate(obj);
    }
}
