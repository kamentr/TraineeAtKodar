package net.kodar.university.dataaccess.dao.student;

import net.kodar.university.data.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDaoGenericImpl extends StudentDaoGeneric {

    @Override
    public Integer getId(Student student) {
        return student.getId();
    }

}
