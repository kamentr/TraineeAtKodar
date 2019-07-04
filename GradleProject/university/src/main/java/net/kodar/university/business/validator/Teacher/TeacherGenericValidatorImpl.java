package net.kodar.university.business.validator.Teacher;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import org.springframework.stereotype.Component;

@Component
public class TeacherGenericValidatorImpl extends GenericValidatorImpl<TeacherParam> implements TeacherGenericValidator {

    @Override
    public void validate(TeacherParam obj){
        super.validate(obj);


    }
}
