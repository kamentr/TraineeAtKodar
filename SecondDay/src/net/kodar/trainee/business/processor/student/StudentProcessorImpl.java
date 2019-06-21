package net.kodar.trainee.business.processor.student;

import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.transformer.GenericParamTransformer;
import net.kodar.trainee.business.transformer.GenericResultTransformer;
import net.kodar.trainee.business.transformer.StudentParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.StudentResultGenericResultTransformer;
import net.kodar.trainee.data.entities.Student;
import net.kodar.trainee.dataaccess.dao.student.StudentDao;
import net.kodar.trainee.dataaccess.dao.student.StudentDaoMapImpl;
import net.kodar.trainee.presentation.parameter.StudentParam;
import net.kodar.trainee.presentation.result.StudentResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        return studentDao
                .getAll()
                .stream()
                .map(s -> resultTransformer.apply(s))
                .collect(Collectors.toList());
    }

    @Override
    public void save(StudentParam t) {
        Student student = new Student();
        studentDao.save(paramTransformer.apply(t, new Student())); //null
    }

    @Override
    public void update(StudentParam t) {

        if(studentDao.getAll().contains(studentDao.get(t.getID()))){
            studentDao.update(paramTransformer.apply(t, studentDao.get(t.getID())));
        }
    }

    @Override
    public void delete(StudentParam t) {
        studentDao.delete(paramTransformer.apply(t, studentDao.get(t.getID())));
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
                .forEach(student -> studentList.add(resultTransformer.apply(studentDao.get(student.getStudentId()))));

        return studentList;

    }
}