package net.kodar.university.dataaccess.dao.discipline;

import net.kodar.university.data.entities.Discipline;
import net.kodar.university.dataaccess.dao.DaoImplGeneric;
import net.kodar.university.dataaccess.dao.discipline.DisciplineDaoGeneric;
import org.springframework.stereotype.Component;

@Component
public class DisciplineDaoGenericImpl extends DaoImplGeneric<Integer, Discipline> implements DisciplineDaoGeneric {

    @Override
    protected Integer getId(Discipline discipline) {
        return discipline.getId();
    }

}
