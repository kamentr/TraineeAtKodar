package net.kodar.universityMVC.dataaccess.dao.teacher;

import net.kodar.universityMVC.data.entities.Teacher;
import net.kodar.universityMVC.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityMVC.dataaccess.repository.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDaoGenericImpl extends DaoImplGeneric<Integer, Teacher> implements net.kodar.universityMVC.dataaccess.dao.teacher.TeacherDaoGeneric {

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
}
