package net.kodar.trainee.business.validator.Student;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.data.entities.Student;

public class StudentGenericValidatorImpl extends GenericValidatorImpl<Student> implements StudentGenericValidator {

    @Override
    public void validate(Student obj){
        super.validate(obj);


    };
}
