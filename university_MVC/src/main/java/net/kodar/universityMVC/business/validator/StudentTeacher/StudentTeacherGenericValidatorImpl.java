package net.kodar.universityMVC.business.validator.StudentTeacher;

import net.kodar.universityMVC.business.validator.GenericValidatorImpl;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherParam;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherParam> implements net.kodar.universityMVC.business.validator.StudentTeacher.StudentTeacherGenericValidator {
    @Override
    public void validate(StudentTeacherParam obj){
        super.validate(obj);


    }
}
