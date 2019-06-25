package net.kodar.trainee.business.processor.teacher;

import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.trainee.business.transformer.param.TeacherParamGenericParamTransformer;
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
        TeacherResult teacherResult = resultTransformer.apply(teacherDao.get(id));
        return teacherResult;
    }

    @Override
    public List<TeacherResult> getAll() {
        List<Teacher> teacherList = teacherDao.getAll();

        return teacherList
                .stream()
                .map(teacher -> resultTransformer.apply(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherParam save(TeacherParam teacher) {
        Teacher teacherToSave = paramTransformer.apply(teacher, null);
        teacherDao.save(teacherToSave);

        return teacher;
    }

    @Override
    public void update(TeacherParam teacher) {
        Teacher t = teacherDao.get(teacher.getId());

        if (null != t) {
            Teacher teacherToUpdate = paramTransformer.apply(teacher, t);
            teacherDao.update(teacherToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(TeacherParam teacher) {
        Teacher t = teacherDao.get(teacher.getId());

        if (null != t) {
            Teacher teacherToDelete = paramTransformer.apply(teacher, t);
            teacherDao.delete(teacherToDelete);
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
                .forEach(teacher -> {

                    TeacherResult teacherToAdd = resultTransformer.apply(teacherDao.get(teacher.getTeacherId()));
                    teacherList.add(teacherToAdd);

                });

        return teacherList;
    }
}
