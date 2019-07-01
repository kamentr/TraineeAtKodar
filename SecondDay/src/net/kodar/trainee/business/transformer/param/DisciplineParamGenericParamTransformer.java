package net.kodar.trainee.business.transformer.param;

import net.kodar.trainee.business.transformer.GenericParamTransformer;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.presentation.parameter.DisciplineParam;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DisciplineParamGenericParamTransformer implements GenericParamTransformer<DisciplineParam, Discipline, Discipline> {
    @Override
    public Discipline apply(DisciplineParam disciplineParam, Discipline discipline) {
        if (discipline == null) {
            discipline = new Discipline();
            discipline.setId(disciplineParam.getId());
        }
        discipline.setId(disciplineParam.getId());
        discipline.setDisciplineName(disciplineParam.getDisciplineName());

        return discipline;
    }

    @Override
    public <V> BiFunction<DisciplineParam, Discipline, V> andThen(Function<? super Discipline, ? extends V> after) {
        return null;
    }
}
