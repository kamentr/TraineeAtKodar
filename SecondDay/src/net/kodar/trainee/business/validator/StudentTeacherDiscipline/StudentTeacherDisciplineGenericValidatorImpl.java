package net.kodar.trainee.business.validator.StudentTeacherDiscipline;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;

public class StudentTeacherDisciplineGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherDisciplineParam> implements StudentTeacherDisciplineGenericValidator {
    @Override
    public void validate(StudentTeacherDisciplineParam obj){
        super.validate(obj);


    };
}
