package net.kodar.university.business.processor.discipline;

import net.kodar.university.business.processor.Processor;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import net.kodar.university.presentation.depricated.result.DisciplineResult;


import java.util.List;


public interface DisciplineProcessorGeneric extends Processor<DisciplineParam, DisciplineResult>
 {
    List<DisciplineResult> getByStudentId(Integer id);

    List<DisciplineResult> getByTeacherId(Integer id);
 }
