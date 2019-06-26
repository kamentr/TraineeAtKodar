package net.kodar.trainee.business.processor.studentteacherdiscipline;

import net.kodar.trainee.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDao;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGeneric;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoGenericImpl;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoImpl;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherDisciplineProcessorImpl implements StudentTeacherDisciplineProcessor {

    private StudentTeacherDisciplineDaoGeneric studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoGenericImpl();
    private StudentTeacherDisciplineParamGenericParamTransformer paramTransformer = new StudentTeacherDisciplineParamGenericParamTransformer();
    private StudentTeacherDisciplineResultGenericResultTransformer resultTransformer = new StudentTeacherDisciplineResultGenericResultTransformer();

    @Override
    public StudentTeacherDisciplineResult get(int id) {
        StudentTeacherDisciplineResult studentTeacherDisciplineResult = resultTransformer.apply(studentTeacherDisciplineDao.get(id));
        return studentTeacherDisciplineResult;
    }

    @Override
    public List<StudentTeacherDisciplineResult> getAll() {
        List<StudentTeacherDiscipline> studentTeacherDisciplineList = studentTeacherDisciplineDao.getAll();

        return studentTeacherDisciplineList
                .stream()
                .map(std -> resultTransformer.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public StudentTeacherDisciplineResult save(StudentTeacherDisciplineParam studentTeacherDiscipline) {
        StudentTeacherDiscipline studentTeacherDisciplineToSave = paramTransformer.apply(studentTeacherDiscipline, null);
        StudentTeacherDiscipline save = studentTeacherDisciplineDao.save(studentTeacherDisciplineToSave);

        return resultTransformer.apply(save);
    }

    @Override
    public void update(StudentTeacherDisciplineParam studentTeacherDiscipline) {
        StudentTeacherDiscipline std = studentTeacherDisciplineDao.get(studentTeacherDiscipline.getId());

        if (std != null) {
            StudentTeacherDiscipline studentTeacherDisciplineToUpdate = paramTransformer.apply(studentTeacherDiscipline, std);
            studentTeacherDisciplineDao.update(studentTeacherDisciplineToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(StudentTeacherDisciplineParam studentTeacherDiscipline) {
        StudentTeacherDiscipline std = studentTeacherDisciplineDao.get(studentTeacherDiscipline.getId());
        if (std != null) {
            StudentTeacherDiscipline studentTeacherDisciplineToDelete = paramTransformer.apply(studentTeacherDiscipline, std);
            studentTeacherDisciplineDao.delete(studentTeacherDisciplineToDelete);
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        studentTeacherDisciplineDao.delete(id);
    }

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
}
