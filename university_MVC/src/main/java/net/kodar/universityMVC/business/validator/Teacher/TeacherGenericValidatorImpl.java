package net.kodar.universityMVC.business.validator.Teacher;

import net.kodar.universityMVC.business.validator.GenericValidatorImpl;
import net.kodar.universityMVC.presentation.model.param.TeacherParam;
import org.springframework.stereotype.Component;

@Component
public class TeacherGenericValidatorImpl extends GenericValidatorImpl<TeacherParam> implements net.kodar.universityMVC.business.validator.Teacher.TeacherGenericValidator {

    @Override
    public void validate(TeacherParam obj){
        super.validate(obj);


    }
}
