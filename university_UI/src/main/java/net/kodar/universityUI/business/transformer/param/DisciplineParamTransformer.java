package net.kodar.universityUI.business.transformer.param;

import net.kodar.universityUI.business.transformer.GenericParamTransformer;
import net.kodar.universityUI.data.entities.Discipline;
import net.kodar.universityUI.presentation.model.param.DisciplineParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class DisciplineParamTransformer implements GenericParamTransformer<DisciplineParam, Discipline, Discipline> {
    @Override
    public Discipline apply(DisciplineParam disciplineParam, Discipline discipline) {
        if (discipline == null) {
            discipline = new Discipline();
            discipline.setId(disciplineParam.getId());
        }
        discipline.setName(disciplineParam.getName());

        return discipline;
    }

    @Override
    public <V> BiFunction<DisciplineParam, Discipline, V> andThen(Function<? super Discipline, ? extends V> after) {
        return null;
    }
}
