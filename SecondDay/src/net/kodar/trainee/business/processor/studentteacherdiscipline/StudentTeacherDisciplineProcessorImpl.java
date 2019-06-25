package net.kodar.trainee.business.processor.studentteacherdiscipline;

import net.kodar.trainee.business.transformer.param.StudentTeacherDisciplineParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherDisciplineResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDao;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoImpl;
import net.kodar.trainee.presentation.parameter.StudentTeacherDisciplineParam;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTeacherDisciplineProcessorImpl implements StudentTeacherDisciplineProcessor {

    private StudentTeacherDisciplineDao studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoImpl();
    private StudentTeacherDisciplineParamGenericParamTransformer paramTransformer = new StudentTeacherDisciplineParamGenericParamTransformer();
    private StudentTeacherDisciplineResultGenericResultTransformer resultTransformer = new StudentTeacherDisciplineResultGenericResultTransformer();

    @Override
    public StudentTeacherDisciplineResult get(int id) {
        return resultTransformer.apply(studentTeacherDisciplineDao.get(id));
    }

    @Override
    public List<StudentTeacherDisciplineResult> getAll() {
        Stream<StudentTeacherDiscipline> studentTeacherDisciplineStream = studentTeacherDisciplineDao
                .getAll()
                .stream();

        return studentTeacherDisciplineStream
                .map(std -> resultTransformer.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public void save(StudentTeacherDisciplineParam studentTeacherDiscipline) {

        studentTeacherDisciplineDao.save(paramTransformer.apply(studentTeacherDiscipline, null));

    }

    @Override
    public void update(StudentTeacherDisciplineParam studentTeacherDiscipline) {
        StudentTeacherDiscipline std = studentTeacherDisciplineDao.get(studentTeacherDiscipline.getId());
        if (std != null) {
            studentTeacherDisciplineDao.update(paramTransformer.apply(studentTeacherDiscipline,std));
        }else {
            //exception
        }
    }

    @Override
    public void delete(StudentTeacherDisciplineParam studentTeacherDiscipline) {
        StudentTeacherDiscipline std = studentTeacherDisciplineDao.get(studentTeacherDiscipline.getId());
        if (std != null) {
            studentTeacherDisciplineDao.delete(paramTransformer.apply(studentTeacherDiscipline,std));
        }else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        studentTeacherDisciplineDao.delete(id);
    }

    @Override
    public List<StudentTeacherDisciplineResult> filterByTeacher(Integer techerId) {
        return studentTeacherDisciplineDao
                .getAll()
                .stream()
                .filter(studentTeacherDiscipline -> studentTeacherDiscipline.getTeacherId() == techerId)
                .map(std->resultTransformer.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherDisciplineResult> filterByStudent(Integer studentId) {
        return studentTeacherDisciplineDao
                .getAll()
                .stream()
                .filter(studentTeacherDiscipline -> studentTeacherDiscipline.getStudentId() == studentId)
                .map(std->resultTransformer.apply(std))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(int id) {
        studentTeacherDisciplineDao.getAll().forEach(studentTeacherDiscipline -> {
            if (studentTeacherDiscipline.getStudentId() == id) {
                studentTeacherDisciplineDao.getAll().remove(studentTeacherDiscipline);
            }
        });
    }

    @Override
    public void deleteTeacher(int id) {
        studentTeacherDisciplineDao.getAll().forEach(studentTeacherDiscipline -> {
            if (studentTeacherDiscipline.getTeacherId() == id) {
                studentTeacherDisciplineDao.getAll().remove(studentTeacherDiscipline);
            }
        });
    }
}
