package net.kodar.trainee.business.validator.StudentTeacherDiscipline;

import net.kodar.trainee.business.validator.GenericValidatorImpl;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;

public class StudentTeacherDisciplineGenericValidatorImpl extends GenericValidatorImpl<StudentTeacherDiscipline> implements StudentTeacherDisciplineGenericValidator {
    @Override
    public void validate(StudentTeacherDiscipline obj){
        super.validate(obj);


    };
}
