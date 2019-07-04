package net.kodar.university.business.validator.StudentTeacherDiscipline;

import net.kodar.university.business.validator.GenericValidatorImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherDisciplineParam;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherDisciplineParam> implements StudentTeacherDisciplineGenericValidator {
    @Override
    public void validate(StudentTeacherDisciplineParam obj){
        super.validate(obj);


    }
}
