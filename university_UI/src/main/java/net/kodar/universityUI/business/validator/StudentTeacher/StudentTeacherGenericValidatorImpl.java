package net.kodar.universityUI.business.validator.StudentTeacher;

import net.kodar.universityUI.business.validator.GenericValidatorImpl;
import net.kodar.universityUI.presentation.model.param.StudentTeacherParam;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherParam> implements StudentTeacherGenericValidator {
    @Override
    public void validate(StudentTeacherParam obj){
        super.validate(obj);


    }
}
