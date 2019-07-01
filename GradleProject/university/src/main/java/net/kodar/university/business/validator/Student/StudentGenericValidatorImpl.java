package net.kodar.university.business.validator.Student;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.parameter.StudentParam;

public class StudentGenericValidatorImpl extends GenericValidatorImpl<StudentParam> implements StudentGenericValidator {

    @Override
    public void validate(StudentParam obj){
        super.validate(obj);
    }
}
