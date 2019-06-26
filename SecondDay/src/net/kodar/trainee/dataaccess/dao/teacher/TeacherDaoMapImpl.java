package net.kodar.trainee.dataaccess.dao.teacher;

import net.kodar.trainee.dataaccess.dao.teacher.data.TeacherDataMap;
import net.kodar.trainee.data.entities.Teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TeacherDaoMapImpl implements TeacherDao {

    private TeacherDataMap teacherDataMap = new TeacherDataMap();
    private Map<Integer, Teacher> teacherData = TeacherDataMap.teacherMap;

    @Override
    public Teacher get(int id) {
        return teacherData.get(id);
    }

    @Override
    public List<Teacher> getAll() {
        return new ArrayList<>(teacherData.values());
    }

    @Override
    public Teacher save(Teacher teacher) {
        teacherData.put(teacher.getId(), teacher);

        Collection<Teacher> teachers = teacherData.values();
        return teachers
                .stream()
                .filter(t -> t.getIdentifier().equals(teacher.getIdentifier()))
                .findFirst()
                .get();
    }

    @Override
    public void update(Teacher teacher) {
        teacherData.put(teacher.getId(), teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherData.remove(teacher.getId(), teacher);
    }

    @Override
    public void delete(int id) {
        teacherData.remove(teacherData.get(id).getId(), teacherData.get(id));
    }
}
