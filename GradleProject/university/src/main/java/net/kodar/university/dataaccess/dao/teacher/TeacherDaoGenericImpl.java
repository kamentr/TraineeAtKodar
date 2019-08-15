package net.kodar.university.dataaccess.dao.teacher;

import net.kodar.university.dataaccess.dao.DaoImplGeneric;
import net.kodar.university.dataaccess.repository.teacher.TeacherRepository;
import net.kodar.university.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public List<Teacher> getTeachersByStudentId(Integer studentId){
        return new ArrayList<>(this.teacherRepository.getTeachersByStudentId(studentId));
    }
}
