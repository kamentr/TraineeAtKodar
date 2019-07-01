package net.kodar.university.business.processor.student;

import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGeneric;
import net.kodar.university.business.processor.studentteacher.StudentTeacherProcessorGenericImpl;
import net.kodar.university.business.transformer.result.StudentResultGenericResultTransformer;
import net.kodar.university.dataaccess.dao.student.StudentDaoGeneric;
import net.kodar.university.dataaccess.dao.student.StudentDaoGenericImpl;
import net.kodar.university.presentation.parameter.StudentParam;
import net.kodar.university.presentation.result.StudentResult;

import java.util.ArrayList;
import java.util.List;

public class StudentProcessorGenericImpl extends StudentProcessorGeneric {

    private StudentTeacherProcessorGeneric studentTeacherProcessor = new StudentTeacherProcessorGenericImpl();
    private StudentResultGenericResultTransformer resultTransformer = new StudentResultGenericResultTransformer();
    private StudentDaoGeneric studentDao = new StudentDaoGenericImpl();

    @Override
    public int getID(StudentParam entity) {
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
