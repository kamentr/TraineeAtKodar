package net.kodar.university.business.validator.Student;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Component
public class StudentGenericValidatorImpl extends GenericValidatorImpl<StudentParam> implements StudentGenericValidator {

    @Override
    public void validate(StudentParam obj) {
        super.validate(obj);

        if(obj.getFirstName().equals("name")){
            throw new ValidationException("Name cannot be left");
        }
    }
}
