package net.kodar.trainee.business.processor.discipline;

import net.kodar.trainee.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessor;
import net.kodar.trainee.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorImpl;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDao;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class DisciplineProcessorImpl implements DisciplineProcessor {

    DisciplineDao disciplineDao = new DisciplineDaoImpl();
    StudentTeacherDisciplineProcessor studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorImpl();


    @Override
    public Discipline get(int id) {
        return disciplineDao.get(id);
    }

    @Override
    public List<Discipline> getAll() {
        return disciplineDao.getAll();
    }

    @Override
    public void save(Discipline discipline) {
        disciplineDao.save(discipline);
    }

    @Override
    public void update(Discipline discipline) {
        disciplineDao.update(discipline);
    }

    @Override
    public void delete(Discipline discipline) {
        disciplineDao.delete(discipline);
    }

    @Override
    public void delete(int id) {
        disciplineDao.delete(id);
    }

    @Override
    public List<Discipline> getByStudentId(Integer id) {
        List<Discipline> disciplineList = new ArrayList<>();

        for (StudentTeacherDiscipline studentid : studentTeacherDisciplineProcessor
                .getAll()) {
            if (studentid.getStudentId() == id) {
                disciplineList.add(disciplineDao.get(studentid.getDisciplineId()));
            }
        }

        return disciplineList;
    }

    @Override
    public List<Discipline> getByTeacherId(Integer id) {
        List<Discipline> disciplineList = new ArrayList<>();

        studentTeacherDisciplineProcessor
                .filterByTeacher(id)
                .forEach(discipline ->
                        disciplineList.add(disciplineDao.get(discipline.getDisciplineId())));

        return disciplineList;
    }
}
