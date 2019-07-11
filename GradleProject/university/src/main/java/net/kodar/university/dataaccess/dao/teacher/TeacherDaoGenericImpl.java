package net.kodar.university.dataaccess.dao.teacher;

import net.kodar.university.data.entities.Teacher;
import net.kodar.university.dataaccess.dao.teacher.data.TeacherDataMap;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TeacherDaoGenericImpl extends TeacherDaoGeneric {

    @Override
    protected Integer getId(Teacher teacher) {
        return teacher.getId();
    }
}
