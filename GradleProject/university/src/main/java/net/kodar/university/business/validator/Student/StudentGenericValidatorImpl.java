package net.kodar.university.business.validator.Student;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import org.springframework.stereotype.Component;

@Component
public class StudentGenericValidatorImpl extends GenericValidatorImpl<StudentParam> implements StudentGenericValidator {

    @Override
    public void validate(StudentParam obj){
        super.validate(obj);
    }
}
