package net.kodar.university.business.validator.StudentTeacher;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherParam> implements StudentTeacherGenericValidator {
    @Override
    public void validate(StudentTeacherParam obj){
        super.validate(obj);


    }
}
