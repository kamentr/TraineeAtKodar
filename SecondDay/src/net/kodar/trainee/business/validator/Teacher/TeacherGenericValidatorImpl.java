package net.kodar.trainee.business.validator.Teacher;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.data.entities.Teacher;

public class TeacherGenericValidatorImpl extends GenericValidatorImpl<Teacher> implements TeacherGenericValidator {

    @Override
    public void validate(Teacher obj){
        super.validate(obj);


    };
}
