package net.kodar.trainee.business.processor.discipline;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.data.entities.Discipline;

import java.util.List;

public interface DisciplineProcessor extends Processor<Discipline> {

    List<Discipline> getByStudentId(Integer id);

    List<Discipline> getByTeacherId(Integer id);
}