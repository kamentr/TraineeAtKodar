package net.kodar.trainee.business.processor.teacher;

import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessor;
import net.kodar.trainee.business.processor.studentteacher.StudentTeacherProcessorImpl;
import net.kodar.trainee.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoGeneric;
import net.kodar.trainee.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.trainee.presentation.parameter.TeacherParam;
import net.kodar.trainee.presentation.result.TeacherResult;

import java.util.ArrayList;
import java.util.List;

public class TeacherProcessorGenericImpl extends TeacherProcessorGeneric {

    private TeacherDaoGeneric teacherDao = new TeacherDaoGenericImpl();
    private StudentTeacherProcessor studentTeacherProcessor = new StudentTeacherProcessorImpl();
    private TeacheResultGenericResultTransformer resultTransformer = new TeacheResultGenericResultTransformer();

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

    @Override
    public int getID(TeacherParam entity) {
        return entity.getId();
    }
}
