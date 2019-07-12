package net.kodar.university.dataaccess.dao.studenteacher;

import net.kodar.university.data.entities.StudentTeacher;
import org.springframework.stereotype.Component;

@Component
public class StudentTeacherDaoGenericImpl extends StudentTeacherDaoGeneric {

    @Override
    protected Integer getId(StudentTeacher studentTeacher) {
        return studentTeacher.getId();
    }

}
