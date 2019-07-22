package net.kodar.university.business.transformer.param;

import net.kodar.university.business.transformer.GenericParamTransformer;
import net.kodar.university.data.entities.Discipline;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class DisciplineParamGenericParamTransformer implements GenericParamTransformer<DisciplineParam, Discipline, Discipline> {
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
