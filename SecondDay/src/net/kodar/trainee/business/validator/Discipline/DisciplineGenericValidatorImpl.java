package net.kodar.trainee.business.validator.Discipline;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.presentation.parameter.DisciplineParam;

import javax.xml.bind.ValidationException;

public class DisciplineGenericValidatorImpl extends GenericValidatorImpl<DisciplineParam> implements DisciplineGenericValidator {

    @Override
    public void validate(DisciplineParam obj){
        super.validate(obj);

    };
}
