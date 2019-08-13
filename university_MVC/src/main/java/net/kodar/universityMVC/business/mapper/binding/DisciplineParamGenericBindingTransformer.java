package net.kodar.universityMVC.business.mapper.binding;

import net.kodar.universityMVC.business.mapper.GenericBindingTransformer;
import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.presentation.model.binding.DisciplineParam;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class DisciplineParamGenericBindingTransformer implements GenericBindingTransformer<DisciplineParam, Discipline, Discipline> {
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
