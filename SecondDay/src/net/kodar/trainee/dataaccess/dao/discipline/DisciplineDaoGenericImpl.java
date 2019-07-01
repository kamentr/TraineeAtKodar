package net.kodar.trainee.dataaccess.dao.discipline;

import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.dataaccess.dao.discipline.data.DisciplineData;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class DisciplineDaoGenericImpl extends DisciplineDaoGeneric{

    @Override
    protected Integer getId(Discipline discipline) {
        return discipline.getId();
    }

    @Override
    protected Discipline getByIdentifier(Discipline discipline) {
        Collection<Discipline> list = getData().values();
        return list
                .stream()
                .filter(ent -> getIdentifier(ent).equals(getIdentifier(discipline)))
                .findFirst()
                .get();
    }

    @Override
    protected UUID getIdentifier(Discipline discipline) {
        return discipline.getIdentifier();
    }

    @Override
    protected Map<Integer, Discipline> getData() {
        DisciplineData disciplineData = new DisciplineData();
        return disciplineData.getDisciplineMapData();
    }
}
