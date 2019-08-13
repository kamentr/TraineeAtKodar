package net.kodar.universityMVC.business.validator.StudentTeacherDiscipline;

import net.kodar.universityMVC.business.validator.GenericValidatorImpl;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherDisciplineParam;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDisciplineGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherDisciplineParam> implements net.kodar.universityMVC.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidator {
    @Override
    public void validate(StudentTeacherDisciplineParam obj){
        super.validate(obj);


    }
}
