package net.kodar.trainee.dataaccess.dao.studentteacherdiscipline;

import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.data.StudentTeacherDisciplineData;

import java.util.*;

public class StudentTeacherDisciplineDaoImpl implements StudentTeacherDisciplineDao {

    private StudentTeacherDisciplineData data = new StudentTeacherDisciplineData();
    private Map<Integer, StudentTeacherDiscipline> studentTeacherDisciplineData = data.getStudentTeacherDisciplineMap();

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
        Collection<StudentTeacherDiscipline> studentTeacherDisciplines = studentTeacherDisciplineData.values();
        return studentTeacherDisciplines
                .stream()
                .filter(std -> std.getIdentifier().equals(studentTeacherDiscipline.getIdentifier()))
                .findFirst()
                .get();
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
