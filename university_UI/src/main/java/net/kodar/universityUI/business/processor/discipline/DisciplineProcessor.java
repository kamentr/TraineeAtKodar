package net.kodar.universityUI.business.processor.discipline;


import net.kodar.universityUI.business.processor.Processor;
import net.kodar.universityUI.presentation.model.param.DisciplineParam;
import net.kodar.universityUI.presentation.model.result.DisciplineResult;

import java.util.List;

@org.springframework.stereotype.Service
public interface DisciplineProcessor extends Processor<DisciplineParam, DisciplineResult> {
    List<DisciplineResult> getDisciplinesByStudentId(int studentId);
}
