package net.kodar.university.business.processor.teacher;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.transformer.param.TeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.TeacheResultGenericResultTransformer;
import net.kodar.university.business.validator.Teacher.TeacherGenericValidatorImpl;
import net.kodar.university.data.entities.Teacher;
import net.kodar.university.dataaccess.dao.teacher.TeacherDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.TeacherParam;
import net.kodar.university.presentation.depricated.result.TeacherResult;

import java.util.ArrayList;
import java.util.List;

public class TeacherProcessorGenericImpl extends ProcessorGenericImpl
        <TeacherParam,
                TeacherResult,
                Integer,
                Teacher,
                TeacherDaoGenericImpl,
                TeacherParamGenericParamTransformer,
                TeacheResultGenericResultTransformer,
                TeacherGenericValidatorImpl> implements TeacherProcessorGeneric{

    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();

    public TeacherProcessorGenericImpl(){
        this.dao = new TeacherDaoGenericImpl();
        this.ptr = new TeacherParamGenericParamTransformer();
        this.rtr = new TeacheResultGenericResultTransformer();
        this.val = new TeacherGenericValidatorImpl();
    }
    @Override
    public List<TeacherResult> getTeachersByStudentId(Integer studentId) {
        List<TeacherResult> teacherList = new ArrayList<>();

        studentTeacherProcessor
                .filterByStudent(studentId)
                .forEach(teacher -> {

                    TeacherResult teacherToAdd = rtr.apply(dao.get(teacher.getTeacherId()));
                    teacherList.add(teacherToAdd);

                });

        return teacherList;
    }

    @Override
    public int getID(TeacherParam entity) {
        return entity.getId();
    }
}
