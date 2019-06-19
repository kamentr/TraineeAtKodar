package net.kodar.trainee.business.discipline;

import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDao;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoImpl;

import java.util.List;

public class DisciplineProcessorImpl implements DisciplineProcessor {

    DisciplineDao disciplineDao = new DisciplineDaoImpl();

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
        return null;
        //todo
    }

    @Override
    public List<Discipline> getByTeacherId(Integer id) {
        return null;
        //todo
    }
}
