package net.kodar.trainee.business.processor.discipline;

import net.kodar.trainee.business.processor.Processor;
import net.kodar.trainee.presentation.parameter.DisciplineParam;
import net.kodar.trainee.presentation.result.DisciplineResult;

import java.util.List;

public interface DisciplineProcessor extends Processor<DisciplineParam, DisciplineResult> {

    List<DisciplineResult> getByStudentId(Integer id);

    List<DisciplineResult> getByTeacherId(Integer id);
}