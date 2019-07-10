package net.kodar.university.dataaccess.repository;

import net.kodar.university.data.entities.Discipline;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
}
