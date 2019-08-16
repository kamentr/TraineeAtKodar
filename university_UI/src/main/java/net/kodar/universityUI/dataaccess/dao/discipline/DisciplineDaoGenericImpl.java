package net.kodar.universityUI.dataaccess.dao.discipline;

import net.kodar.universityUI.data.entities.Discipline;
import net.kodar.universityUI.dataaccess.dao.DaoImplGeneric;
import net.kodar.universityUI.dataaccess.repository.discipline.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisciplineDaoGenericImpl extends DaoImplGeneric<Integer, Discipline> implements DisciplineDaoGeneric {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Override
    protected Integer getId(Discipline discipline) {
        return discipline.getId();
    }

    @Override
    public List<Discipline> getDisciplinesByStudentId(int studentId) {
        return this.disciplineRepository.getDisciplinesByStudentId(studentId);
    }

    @Override
    protected Class<Discipline> getClazz() {
        return Discipline.class;
    }
}
