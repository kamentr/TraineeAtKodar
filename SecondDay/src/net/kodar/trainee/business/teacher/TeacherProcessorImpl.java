package net.kodar.trainee.business.teacher;

import net.kodar.trainee.business.studentTeacher.StudentTeacherProcessor;
import net.kodar.trainee.business.studentTeacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDao;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDaoMapImpl;


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
    public List<Teacher> getTeachersByStudent(Student student) {
        return studentTeacherProcessor.getTeachersByStudent(student);
    }
}
