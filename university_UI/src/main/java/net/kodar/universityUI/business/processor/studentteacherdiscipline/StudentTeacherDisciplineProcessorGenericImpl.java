package net.kodar.universityUI.business.processor.studentteacherdiscipline;


import net.kodar.universityUI.business.processor.ProcessorImpl;
import net.kodar.universityUI.business.transformer.param.StudentTeacherDisciplineParamTransformer;
import net.kodar.universityUI.business.transformer.result.StudentTeacherDisciplineResultTransformer;
import net.kodar.universityUI.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidatorImpl;
import net.kodar.universityUI.data.entities.StudentTeacherDiscipline;
import net.kodar.universityUI.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGenericImpl;
import net.kodar.universityUI.presentation.model.param.StudentTeacherDisciplineParam;
import net.kodar.universityUI.presentation.model.result.StudentTeacherDisciplineResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherDisciplineProcessorGenericImpl extends ProcessorImpl
        <StudentTeacherDisciplineParam,
                StudentTeacherDisciplineResult,
                Integer,
                StudentTeacherDiscipline,
                StudentTeacherDisciplineDaoGenericImpl,
                StudentTeacherDisciplineParamTransformer,
                StudentTeacherDisciplineResultTransformer,
                StudentTeacherDisciplineGenericValidatorImpl> implements StudentTeacherDisciplineProcessorGeneric {

    private StudentTeacherDisciplineDaoGenericImpl studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoGenericImpl();

    @Override
    public List<StudentTeacherDisciplineResult> filterByTeacher(Integer teacherId) {
        List<StudentTeacherDiscipline> studentTeacherDisciplineList = studentTeacherDisciplineDao.getAll();

        return studentTeacherDisciplineList
                .stream()
                .filter(std -> std.getTeacher().getId()==(teacherId))
                .map(std -> rtr.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId) {
        List<StudentTeacherDiscipline> studentTeacherDisciplines = studentTeacherDisciplineDao.getAll();

        return studentTeacherDisciplines
                .stream()
                .filter(std -> std.getStudent().getId().equals(studentId))
                .map(std -> rtr.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(int id) {
        studentTeacherDisciplineDao.getAll()
                .forEach(studentTeacherDiscipline ->
                {
                    if (studentTeacherDiscipline.getStudent().getId() == id) {
                        studentTeacherDisciplineDao
                                .getAll()
                                .remove(studentTeacherDiscipline);
                    }
                });
    }

    @Override
    public void deleteTeacher(int id) {
        studentTeacherDisciplineDao.getAll()
                .forEach(studentTeacherDiscipline ->
                {
                    if (studentTeacherDiscipline.getTeacher().getId() == id) {
                        studentTeacherDisciplineDao
                                .getAll()
                                .remove(studentTeacherDiscipline);
                    }
                });
    }

    @Override
    public int getID(StudentTeacherDisciplineParam entity) {
        return entity.getId();
    }
}
