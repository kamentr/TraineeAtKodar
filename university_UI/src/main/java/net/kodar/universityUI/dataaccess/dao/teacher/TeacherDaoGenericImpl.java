package net.kodar.universityUI.dataaccess.dao.teacher;

import net.kodar.universityUI.data.entities.Teacher;
import net.kodar.universityUI.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityUI.dataaccess.repository.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDaoGenericImpl extends DaoImplGeneric<Integer, Teacher> implements TeacherDaoGeneric {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    protected Integer getId(Teacher teacher) {
        return teacher.getId();
    }

    @Override
    public List<Teacher> getTeachersByStudentId(Integer studentId) {
        return teacherRepository.getTeachersByStudentId(studentId);
    }

    @Override
    protected Class<Teacher> getClazz() {
        return Teacher.class;
    }
}
