package net.kodar.universityMVC.business.validator.Student;

import net.kodar.universityMVC.business.validator.GenericValidatorImpl;
import net.kodar.universityMVC.presentation.model.binding.StudentBinding;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Component
public class StudentGenericValidatorImpl extends GenericValidatorImpl<StudentBinding> implements StudentGenericValidator {

    @Override
    public void validate(StudentBinding obj) {
        super.validate(obj);

        if(obj.getFirstName().equals("name")){
            throw new ValidationException("Name cannot be left");
        }
    }
}
