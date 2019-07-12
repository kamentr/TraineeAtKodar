package net.kodar.university.dataaccess.dao.teacher;

import net.kodar.university.data.entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherDaoGenericImpl extends TeacherDaoGeneric {

    @Override
    protected Integer getId(Teacher teacher) {
        return teacher.getId();
    }
}
