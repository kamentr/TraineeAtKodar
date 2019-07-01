package net.kodar.university.business.processor.teacher;

import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.university.dataaccess.dao.teacher.TeacherDaoGeneric;
import net.kodar.university.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.university.presentation.parameter.TeacherParam;
import net.kodar.university.presentation.result.TeacherResult;

import java.util.ArrayList;
import java.util.List;

public class TeacherProcessorGenericImpl extends TeacherProcessorGeneric {

    private TeacherDaoGeneric teacherDao = new TeacherDaoGenericImpl();
    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();
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
