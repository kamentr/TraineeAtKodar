package net.kodar.trainee.business.validator.Student;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.presentation.parameter.StudentParam;

public class StudentGenericValidatorImpl extends GenericValidatorImpl<StudentParam> implements StudentGenericValidator {

    @Override
    public void validate(StudentParam obj){
        super.validate(obj);
    }
}
