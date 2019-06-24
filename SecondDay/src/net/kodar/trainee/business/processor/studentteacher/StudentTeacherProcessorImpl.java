package net.kodar.trainee.business.processor.studentteacher;

import net.kodar.trainee.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDao;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoImpl;
import net.kodar.trainee.presentation.parameter.StudentTeacherParam;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    private List<StudentTeacher> studentTeacherList;
    private StudentTeacherDao studentTeacherDao = new StudentTeacherDaoImpl();
    private StudentTeacherResultGenericResultTransformer resultTransformer = new StudentTeacherResultGenericResultTransformer();
    private StudentTeacherParamGenericParamTransformer paramTransformer = new StudentTeacherParamGenericParamTransformer();

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
        return studentTeacherList.stream()
                .filter(teacher -> teacher.getTeacherId() == id)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteStudent(int id) {

        studentTeacherList = studentTeacherList
                .stream()
                .filter(studentTeacher -> studentTeacher.getStudentId() != id)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteTeacher(int id) {
        studentTeacherList = studentTeacherList
                .stream()
                .filter(studentTeacher -> studentTeacher.getTeacherId() != id)
                .collect(Collectors.toList());
    }

    public StudentTeacherResult get(int id) {
        return resultTransformer.apply(studentTeacherDao.get(id));
    }

    public List<StudentTeacherResult> getAll() {
        Stream<StudentTeacher> studentTeacherStream = studentTeacherDao.getAll().stream();
        return studentTeacherStream.map(st -> resultTransformer.apply(st)).collect(Collectors.toList());
    }

    @Override
    public void save(StudentTeacherParam t) {
        studentTeacherDao.save(paramTransformer.apply(t, null));
    }

    @Override
    public void update(StudentTeacherParam t) {
        StudentTeacher studentTeacher = studentTeacherDao.get(t.getId());

        if (studentTeacher != null) {
            studentTeacherDao.update(paramTransformer.apply(t, studentTeacher));
        } else {
            //exception
        }
    }

    @Override
    public void delete(StudentTeacherParam t) {
        StudentTeacher studentTeacher = studentTeacherDao.get(t.getId());
        if (studentTeacher != null) {
            studentTeacherDao.delete(paramTransformer.apply(t, studentTeacher));
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        studentTeacherDao.delete(id);
    }

}
