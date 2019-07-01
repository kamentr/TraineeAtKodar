package net.kodar.trainee.business.transformer.result;

import net.kodar.trainee.business.transformer.GenericResultTransformer;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.presentation.result.DisciplineResult;

public class DisciplineResultGenericResultTransformer implements GenericResultTransformer<Discipline, DisciplineResult> {
    @Override
    public DisciplineResult apply(Discipline discipline) {
        DisciplineResult disciplineResult = new DisciplineResult();

        disciplineResult.setDisciplineName(discipline.getDisciplineName());
        disciplineResult.setId(discipline.getId());

        return disciplineResult;
    }
}
