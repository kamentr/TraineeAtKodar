package net.kodar.trainee.business.studentteacher;

import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.student.StudentDao;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.dataaccess.dao.studentTeacher.StudentTeacherDao;
import net.kodar.trainee.dataaccess.dao.studentTeacher.StudentTeacherDaoImpl;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDao;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoMapImpl;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    private List<StudentTeacher> studentTeacherList;
    private StudentDao studentDao = new StudentDaoMapImpl();
    private TeacherDao teacherDao = new TeacherDaoMapImpl();
    private StudentTeacherDao studentTeacherDao = new StudentTeacherDaoImpl();


    public StudentTeacherProcessorImpl() {
        studentTeacherList = studentTeacherDao.getAll();
    }


    @Override
    public List<StudentTeacher> filterByStudent(Integer id) {
        return studentTeacherList.stream().filter(student -> student.getStudentId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacher> filterByTeacher(Integer id) {
        return studentTeacherList.stream().filter(teacher -> teacher.getTeacherId() == id).collect(Collectors.toList());

    }
}
