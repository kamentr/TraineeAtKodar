package net.kodar.university.business.processor.student;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.university.business.validator.GenericValidator;
import net.kodar.university.business.validator.Student.StudentGenericValidatorImpl;
import net.kodar.university.data.entities.Student;
import net.kodar.university.dataaccess.dao.DaoImplGeneric;
import net.kodar.university.dataaccess.dao.student.StudentDaoGeneric;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentParam;
import net.kodar.university.presentation.depricated.result.StudentResult;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class StudentProcessorGenericImpl extends ProcessorGenericImpl
        <StudentParam, StudentResult, Integer, Student,
                StudentDaoGenericImpl,
                StudentParamGenericParamTransformer,
                StudentResultGenericResultTransformer,
                StudentGenericValidatorImpl>
        implements StudentProcessorGeneric {

    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();
    private StudentResultGenericResultTransformer resultTransformer = new StudentResultGenericResultTransformer();
    private StudentDaoGeneric studentDao = new StudentDaoGenericImpl();

    public StudentProcessorGenericImpl(){
        this.dao = new StudentDaoGenericImpl();
        this.ptr = new StudentParamGenericParamTransformer();
        this.rtr = new StudentResultGenericResultTransformer();
        this.val = new StudentGenericValidatorImpl();
    }

    @Override
    public int getID(StudentParam entity) {
        val.validate(entity);
        return entity.getID();
    }

    @Override
    public List<StudentResult> getStudentsByTeacherId(Integer teacherId) {
        List<StudentResult> studentList = new ArrayList<>();

        studentTeacherProcessor
                .filterByTeacher(teacherId)
                .forEach(student -> {

                    StudentResult studentToAdd = resultTransformer.apply(studentDao.get(student.getId()));
                    studentList.add(studentToAdd);

                });

        return studentList;
    }

}
