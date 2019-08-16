package net.kodar.universityUI.business.validator.Teacher;

import net.kodar.universityUI.business.validator.GenericValidatorImpl;
import net.kodar.universityUI.presentation.model.param.TeacherParam;
import org.springframework.stereotype.Component;

@Component
public class TeacherGenericValidatorImpl extends GenericValidatorImpl<TeacherParam> implements TeacherGenericValidator {

    @Override
    public void validate(TeacherParam obj){
        super.validate(obj);


    }
}
