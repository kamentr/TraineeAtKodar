package net.kodar.university.dataaccess.dao.student;

import net.kodar.university.data.entities.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Component
public class StudentDaoGenericImpl extends StudentDaoGeneric {

    @Override
    protected Integer getId(Student student) {
        return student.getId();
    }

}
