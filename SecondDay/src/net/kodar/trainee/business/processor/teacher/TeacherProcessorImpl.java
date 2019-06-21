package net.kodar.trainee.business.processor.teacher;

import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.transformer.TeacheResultGenericResultTransformer;
import net.kodar.trainee.business.transformer.TeacherParamGenericParamTransformer;
import net.kodar.trainee.data.entities.Teacher;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDao;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoMapImpl;
import net.kodar.trainee.presentation.parameter.TeacherParam;
import net.kodar.trainee.presentation.result.TeacherResult;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeacherProcessorImpl implements TeacherProcessor {

    private TeacherDao teacherDao = new TeacherDaoMapImpl();
    private StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();
    private TeacherParamGenericParamTransformer paramTransformer = new TeacherParamGenericParamTransformer();
    private TeacheResultGenericResultTransformer resultTransformer = new TeacheResultGenericResultTransformer();

    @Override
    public TeacherResult get(int id) {
        return resultTransformer.apply(teacherDao.get(id));
    }

    @Override
    public List<TeacherResult> getAll() {
        Stream<Teacher> teacherStream = teacherDao.getAll().stream();
        return teacherStream
                .map(teacher -> resultTransformer.apply(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public void save(TeacherParam teacher) {

        teacherDao.save(paramTransformer.apply(teacher, null));
    }

    @Override
    public void update(TeacherParam teacher) {
        Teacher teacherToUpdate = teacherDao.get(teacher.getId());

        if (null != teacherToUpdate) {
            teacherDao.update(paramTransformer.apply(teacher, teacherToUpdate));
        } else {
            //exception
        }
    }

    @Override
    public void delete(TeacherParam teacher) {
        Teacher teacherToDel = teacherDao.get(teacher.getId());

        if (null != teacherToDel) {
            teacherDao.delete(paramTransformer.apply(teacher, teacherToDel));
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        teacherDao.delete(id);
    }

    @Override
    public List<TeacherResult> getTeachersByStudentId(Integer studentId) {
        List<TeacherResult> teacherList = new ArrayList<>();

        studentTeacherProcessor
                .filterByStudent(studentId)
                .forEach(teacher -> teacherList.add(resultTransformer.apply(teacherDao.get(teacher.getTeacherId()))));

        return teacherList;
    }
}
