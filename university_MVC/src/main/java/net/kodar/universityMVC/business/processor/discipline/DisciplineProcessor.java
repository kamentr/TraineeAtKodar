package net.kodar.universityMVC.business.processor.discipline;

import net.kodar.universityMVC.business.processor.Processor;
import net.kodar.universityMVC.presentation.model.param.DisciplineParam;
import net.kodar.universityMVC.presentation.model.result.DisciplineResult;

import java.util.List;

@org.springframework.stereotype.Service
public interface DisciplineProcessor extends Processor<DisciplineParam, DisciplineResult> {
    List<DisciplineResult> getDisciplinesByStudentId(int studentId);
}
