package net.kodar.trainee.business.student;

import net.kodar.trainee.business.studentTeacher.StudentTeacherProcessor;
import net.kodar.trainee.business.studentTeacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataАccess.dao.student.StudentDao;
import net.kodar.trainee.dataАccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDao;
import net.kodar.trainee.dataАccess.dao.teacher.TeacherDaoMapImpl;

import java.util.List;

public class StudentProcessorImpl implements StudentProcessor {

    private StudentDao studentDao = new StudentDaoMapImpl();
    private StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();

    private TeacherDao teacherDao = new TeacherDaoMapImpl();


    @Override
    public Student get(int id) {

        return studentDao.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void save(Student t) {
        studentDao.save(t);
    }

    @Override
    public void update(Student t) {
        studentDao.update(t);
    }

    @Override
    public void delete(Student t) {
        studentDao.delete(t);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public List<Student> getStudentsByTeacher(Teacher teacher) {

        return studentTeacherProcessor.getStudentsByTeacher(teacher);
    }
}
