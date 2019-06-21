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

public class TeacherProcessorImpl implements TeacherProcessor {

    TeacherDao teacherDao = new TeacherDaoMapImpl();
    StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();
    TeacherParamGenericParamTransformer paramTransformer = new TeacherParamGenericParamTransformer();
    TeacheResultGenericResultTransformer resultTransformer = new TeacheResultGenericResultTransformer();

    @Override
    public TeacherResult get(int id) {
        return resultTransformer.apply(teacherDao.get(id));
    }

    @Override
    public List<TeacherResult> getAll() {
        return teacherDao
                .getAll()
                .stream()
                .map(teacher -> resultTransformer.apply(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public void save(TeacherParam teacher) {

        teacherDao.save(paramTransformer.apply(teacher, new Teacher()));
    }

    @Override
    public void update(TeacherParam teacher) {

        if(teacherDao.getAll().contains(teacherDao.get(teacher.getId()))){
            teacherDao.update(paramTransformer.apply(teacher, teacherDao.get(teacher.getId())));
        }
    }

    @Override
    public void delete(TeacherParam teacher) {
        teacherDao.delete(paramTransformer.apply(teacher, teacherDao.get(teacher.getId())));
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
