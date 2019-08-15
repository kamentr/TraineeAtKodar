package net.kodar.university.business.transformer.result;

import net.kodar.university.business.transformer.GenericResultTransformer;
import net.kodar.university.entities.Discipline;
import net.kodar.university.presentation.depricated.result.DisciplineResult;
import org.springframework.stereotype.Component;

@Component
public class DisciplineResultGenericResultTransformer implements GenericResultTransformer<Discipline, DisciplineResult> {
    @Override
    public DisciplineResult apply(Discipline discipline) {
        DisciplineResult disciplineResult = new DisciplineResult();
        disciplineResult.setName(discipline.getName());
        disciplineResult.setId(discipline.getId());

        return disciplineResult;
    }
}
