package net.kodar.universityMVC.business.validator.Student;

import net.kodar.universityMVC.business.validator.GenericValidatorImpl;
import net.kodar.universityMVC.presentation.model.param.StudentParam;
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
