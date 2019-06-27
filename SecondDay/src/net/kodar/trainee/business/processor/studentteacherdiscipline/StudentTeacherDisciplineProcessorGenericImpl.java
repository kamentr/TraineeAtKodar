package net.kodar.trainee.business.processor.studentteacherdiscipline;

import net.kodar.trainee.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGenericImpl;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherDisciplineProcessorGenericImpl extends StudentTeacherDisciplineProcessorGeneric {

    private StudentTeacherDisciplineDaoGeneric studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoGenericImpl();
    private StudentTeacherDisciplineParamGenericParamTransformer paramTransformer = new StudentTeacherDisciplineParamGenericParamTransformer();
    private StudentTeacherDisciplineResultGenericResultTransformer resultTransformer = new StudentTeacherDisciplineResultGenericResultTransformer();

    @Override
    public List<StudentTeacherDisciplineResult> filterByTeacher(Integer teacherId) {
        List<StudentTeacherDiscipline> studentTeacherDisciplineList = studentTeacherDisciplineDao.getAll();

        return studentTeacherDisciplineList
                .stream()
                .filter(std -> std.getTeacherId().equals(teacherId))
                .map(std -> resultTransformer.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId) {
        List<StudentTeacherDiscipline> studentTeacherDisciplines = studentTeacherDisciplineDao.getAll();

        return studentTeacherDisciplines
                .stream()
                .filter(std -> std.getStudentId().equals(studentId))
                .map(std -> resultTransformer.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(int id) {
        studentTeacherDisciplineDao.getAll()
                .forEach(studentTeacherDiscipline ->
                {
                    if (studentTeacherDiscipline.getStudentId() == id) {
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
                    if (studentTeacherDiscipline.getTeacherId() == id) {
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
