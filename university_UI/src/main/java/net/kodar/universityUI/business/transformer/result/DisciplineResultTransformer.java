package net.kodar.universityUI.business.transformer.result;

import net.kodar.universityUI.business.transformer.GenericResultTransformer;
import net.kodar.universityUI.data.entities.Discipline;
import net.kodar.universityUI.presentation.model.result.DisciplineResult;
import org.springframework.stereotype.Component;

@Component
public class DisciplineResultTransformer implements GenericResultTransformer<Discipline, DisciplineResult> {
    @Override
    public DisciplineResult apply(Discipline discipline) {
        DisciplineResult disciplineResult = new DisciplineResult();
        disciplineResult.setName(discipline.getName());
        disciplineResult.setId(discipline.getId());

        return disciplineResult;
    }
}
