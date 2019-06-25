package net.kodar.trainee.dataaccess.dao.studentteacherdiscipline;

import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.data.StudentTeacherDisciplineData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTeacherDisciplineDaoImpl implements StudentTeacherDisciplineDao {

    private StudentTeacherDisciplineData data = new StudentTeacherDisciplineData();
    private Map<Integer, StudentTeacherDiscipline> studentTeacherDisciplineData = StudentTeacherDisciplineData.studentTeacherDisciplineMap;

    @Override
    public StudentTeacherDiscipline get(int id) {
        return studentTeacherDisciplineData.get(id);
    }

    @Override
    public List<StudentTeacherDiscipline> getAll() {

        return new ArrayList<>(studentTeacherDisciplineData.values());
    }

    @Override
    public StudentTeacherDiscipline save(StudentTeacherDiscipline studentTeacherDiscipline) {
        studentTeacherDisciplineData.put(studentTeacherDiscipline.getDisciplineId(), studentTeacherDiscipline);
        return studentTeacherDisciplineData.get(studentTeacherDiscipline.getId());
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
