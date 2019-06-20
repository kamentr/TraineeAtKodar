package net.kodar.trainee.dataaccess.dao.discipline;

import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.dataaccess.dao.discipline.data.DisciplineData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DisciplineDaoImpl implements DisciplineDao {


    DisciplineData dataLoad = new DisciplineData();
    private Map<Integer, Discipline> disciplineData  = DisciplineData.disciplineMapData;

    @Override
    public Discipline get(int id) {
        return disciplineData.get(id);
    }

    @Override
    public List<Discipline> getAll() {
        return new ArrayList<>(disciplineData.values());
    }

    @Override
    public void save(Discipline discipline) {
        disciplineData.put(disciplineData.size() + 1, discipline);
    }

    @Override
    public void update(Discipline discipline) {

        disciplineData.put(discipline.getId(), new Discipline(discipline.getId(), discipline.getDisciplineName()));
    }

    @Override
    public void delete(Discipline discipline) {
        if(disciplineData.containsKey(discipline.getId()))
        disciplineData.remove(discipline);
    }

    @Override
    public void delete(int id) {
        disciplineData.remove(id);
    }
}
