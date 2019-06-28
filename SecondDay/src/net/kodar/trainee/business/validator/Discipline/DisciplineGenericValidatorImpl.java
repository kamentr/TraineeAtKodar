package net.kodar.trainee.business.validator.Discipline;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.data.entities.Discipline;

import javax.xml.bind.ValidationException;

public class DisciplineGenericValidatorImpl extends GenericValidatorImpl<Discipline> implements DisciplineGenericValidator {

    @Override
    public void validate(Discipline obj){
        super.validate(obj);

    };
}
