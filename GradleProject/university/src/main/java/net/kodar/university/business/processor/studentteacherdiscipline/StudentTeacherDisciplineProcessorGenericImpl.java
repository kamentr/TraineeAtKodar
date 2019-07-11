package net.kodar.university.business.processor.studentteacherdiscipline;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacherDiscipline;
import net.kodar.university.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.university.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherDisciplineParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherDisciplineProcessorGenericImpl extends ProcessorGenericImpl
        <StudentTeacherDisciplineParam,
                StudentTeacherDisciplineResult,
                Integer,
                StudentTeacherDiscipline,
                StudentTeacherDisciplineDaoGeneric,
                StudentTeacherDisciplineParamGenericParamTransformer,
                StudentTeacherDisciplineResultGenericResultTransformer,
                StudentTeacherDisciplineGenericValidatorImpl> implements StudentTeacherDisciplineProcessorGeneric {

    private StudentTeacherDisciplineDaoGeneric studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoGenericImpl();

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
