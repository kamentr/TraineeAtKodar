package net.kodar.trainee.dataaccess.dao.teacher;

import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataaccess.dao.teacher.data.TeacherDataMap;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class TeacherDaoGenericImpl extends TeacherDaoGeneric {

    @Override
    protected Integer getId(Teacher teacher) {
        return teacher.getId();
    }

    @Override
    protected Teacher getByIdentifier(Teacher teacher) {
        Collection<Teacher> list = getData().values();
        return list
                .stream()
                .filter(t -> getIdentifier(t).equals(getIdentifier(teacher)))
                .findFirst()
                .get();
    }

    @Override
    protected UUID getIdentifier(Teacher teacher) {
        return teacher.getIdentifier();
    }

    @Override
    protected Map<Integer, Teacher> getData() {
        TeacherDataMap teacherDataMap = new TeacherDataMap();
        return teacherDataMap.getTeacherMap();
    }
}
