package net.kodar.universityUI.business.validator.StudentTeacherDiscipline;

import net.kodar.universityUI.business.validator.GenericValidatorImpl;
import net.kodar.universityUI.presentation.model.param.StudentTeacherDisciplineParam;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherDisciplineParam> implements StudentTeacherDisciplineGenericValidator {
    @Override
    public void validate(StudentTeacherDisciplineParam obj){
        super.validate(obj);


    }
}
