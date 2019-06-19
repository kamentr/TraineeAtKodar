package net.kodar.trainee.dataaccess.dao.studentteacherdiscipline;

import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.data.StudentTeacherDisciplineData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTeacherDisciplineDaoImpl implements StudentTeacherDisciplineDao {

    Map<Integer, StudentTeacherDiscipline> studentTeacherDisciplineData = new HashMap<>();
    StudentTeacherDisciplineData data = new StudentTeacherDisciplineData();

    @Override
    public StudentTeacherDiscipline get(int id) {
        return studentTeacherDisciplineData.get(id);
    }

    @Override
    public List<StudentTeacherDiscipline> getAll() {
        return new ArrayList<>(studentTeacherDisciplineData.values());
    }

    @Override
    public void save(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineData.put(studentTeacherDiscipline.getDisciplineId(), studentTeacherDiscipline);
    }

    @Override
    public void update(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineData.put(studentTeacherDiscipline.getDisciplineId(), studentTeacherDiscipline);
    }

    @Override
    public void delete(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineData.remove(studentTeacherDiscipline.getDisciplineId(), studentTeacherDiscipline);
    }

    @Override
    public void delete(int id) {
        studentTeacherDisciplineData.remove(id);
    }
}
