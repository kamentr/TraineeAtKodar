package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.data.entities.Discipline;
import net.kodar.university.presentation.result.DisciplineResult;

public class DisciplineResultGenericResultTransformer implements GenericResultTransformer<Discipline, DisciplineResult> {
    @Override
    public DisciplineResult apply(Discipline discipline) {
        DisciplineResult disciplineResult = new DisciplineResult();

        disciplineResult.setDisciplineName(discipline.getDisciplineName());
        disciplineResult.setId(discipline.getId());

        return disciplineResult;
    }
}
