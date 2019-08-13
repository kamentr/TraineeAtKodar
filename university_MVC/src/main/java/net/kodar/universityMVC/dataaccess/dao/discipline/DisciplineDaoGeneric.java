package net.kodar.universityMVC.dataaccess.dao.discipline;

import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.dataaccess.dao.Dao;

import java.util.List;

public interface DisciplineDaoGeneric extends Dao<Discipline> {
    List<Discipline> getDisciplinesByStudentId(int studentId);
}
