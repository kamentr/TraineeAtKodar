package net.kodar.universityMVC.business.service.studentteacherdiscipline;

import net.kodar.universityMVC.business.service.ServiceImpl;
import net.kodar.universityMVC.business.mapper.binding.StudentTeacherDisciplineParamGenericBindingTransformer;
import net.kodar.universityMVC.business.mapper.view.StudentTeacherDisciplineResultGenericViewTransformer;
import net.kodar.universityMVC.business.validator.StudentTeacherDiscipline.StudentTeacherDisciplineGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.StudentTeacherDiscipline;
import net.kodar.universityMVC.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.binding.StudentTeacherDisciplineParam;
import net.kodar.universityMVC.presentation.model.view.StudentTeacherDisciplineResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherDisciplineProcessorGenericImpl extends ServiceImpl
        <StudentTeacherDisciplineParam,
                StudentTeacherDisciplineResult,
                Integer,
                StudentTeacherDiscipline,
                StudentTeacherDisciplineDaoGenericImpl,
                StudentTeacherDisciplineParamGenericBindingTransformer,
                StudentTeacherDisciplineResultGenericViewTransformer,
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
