package net.kodar.trainee.business.teacher;

import net.kodar.trainee.business.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDao;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoMapImpl;


import java.util.ArrayList;
import java.util.List;

public class TeacherProcessorImpl implements TeacherProcessor {

    TeacherDao teacherDao = new TeacherDaoMapImpl();
    StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();


    @Override
    public Teacher get(int id) {
        return teacherDao.get(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    @Override
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    @Override
    public void delete(int id) {
        teacherDao.delete(id);
    }

    @Override
    public List<Teacher> getTeachersByStudentId(Integer studentId) {
        List<Teacher> teacherList = new ArrayList<>();

        studentTeacherProcessor
                .filterByStudent(studentId)
                .forEach(teacher -> teacherList.add(teacherDao.get(teacher.getTeacherId())));

        return teacherList;
    }
}
