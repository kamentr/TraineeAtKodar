package net.kodar.universityUI.dataaccess.dao.discipline;

import net.kodar.universityUI.data.entities.Discipline;
import net.kodar.universityUI.dataaccess.dao.Dao;

import java.util.List;

public interface DisciplineDaoGeneric extends Dao<Discipline> {
    List<Discipline> getDisciplinesByStudentId(int studentId);
}
