package net.kodar.trainee.business.processor.student;

import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.dataaccess.dao.student.StudentDao;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.presentation.parameter.StudentParam;
import net.kodar.trainee.presentation.result.StudentResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcessorImpl implements StudentProcessor {

    private StudentDao studentDao = new StudentDaoMapImpl();
    private StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();
    private StudentParamGenericParamTransformer paramTransformer = new StudentParamGenericParamTransformer();
    private StudentResultGenericResultTransformer resultTransformer = new StudentResultGenericResultTransformer();

    @Override
    public StudentResult get(int id) {

        return resultTransformer.apply(studentDao.get(id));
    }

    @Override
    public List<StudentResult> getAll() {
        List<Student> studentStream = studentDao.getAll();

        List<StudentResult> studentResults= studentStream
                .stream()
                .map(s -> resultTransformer.apply(s))
                .collect(Collectors.toList());

        return studentResults;
    }

    @Override
    public void save(StudentParam t) {
        Student student = studentDao.get(t.getID());
        if(student != null) {
            Student studentToSave = paramTransformer.apply(t, null);
            studentDao.save(studentToSave);
        }else {
            //exception
        }
    }

    @Override
    public void update(StudentParam t) {
        Student student = studentDao.get(t.getID());

        if (null != student) {
            Student studentToUpdate = paramTransformer.apply(t,student);
            studentDao.update(studentToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(StudentParam t) {
        Student student = studentDao.get(t.getID());

        if (null != student) {
            Student studentToDelete = paramTransformer.apply(t,student);
            studentDao.delete(studentToDelete);
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }

    @Override
    public List<StudentResult> getStudentsByTeacherId(Integer teacherId) {
        List<StudentResult> studentList = new ArrayList<>();

        studentTeacherProcessor
                .filterByTeacher(teacherId)
                .forEach(student -> {

                    int studentid = student.getStudentId();
                    studentList.add(resultTransformer.apply(studentDao.get(studentid)));

                });

        return studentList;
    }
}