package net.kodar.trainee.business.studentteacherdiscipline;

import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDao;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.StudentTeacherDisciplineDaoImpl;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherDisciplineProcessorImpl implements StudentTeacherDisciplineProcessor {

    private StudentTeacherDisciplineDao studentTeacherDisciplineDao = new StudentTeacherDisciplineDaoImpl();

    @Override
    public StudentTeacherDiscipline get(int id) {
        return studentTeacherDisciplineDao.get(id);
    }

    @Override
    public List<StudentTeacherDiscipline> getAll() {
        return studentTeacherDisciplineDao.getAll();
    }

    @Override
    public void save(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineDao.save(studentTeacherDiscipline);
    }

    @Override
    public void update(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineDao.update(studentTeacherDiscipline);
    }

    @Override
    public void delete(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineDao.delete(studentTeacherDiscipline);
    }

    @Override
    public void delete(int id) {
        studentTeacherDisciplineDao.delete(id);
    }

    @Override
    public List<StudentTeacherDiscipline> filterByTeacher(Integer techerId) {
        return studentTeacherDisciplineDao
                .getAll()
                .stream()
                .filter(studentTeacherDiscipline -> studentTeacherDiscipline.getTeacherId() == techerId)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherDiscipline> filterByStudent(Integer studentId) {
        return studentTeacherDisciplineDao
                .getAll()
                .stream()
                .filter(studentTeacherDiscipline -> studentTeacherDiscipline.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(int id) {
        studentTeacherDisciplineDao.getAll().forEach(studentTeacherDiscipline -> {
            if(studentTeacherDiscipline.getStudentId() == id){
                studentTeacherDisciplineDao.getAll().remove(studentTeacherDiscipline);
            }
        });
    }

    @Override
    public void deleteTeacher(int id) {
        studentTeacherDisciplineDao.getAll().forEach(studentTeacherDiscipline -> {
            if(studentTeacherDiscipline.getTeacherId() == id){
                studentTeacherDisciplineDao.getAll().remove(studentTeacherDiscipline);
            }
        });
    }
}
