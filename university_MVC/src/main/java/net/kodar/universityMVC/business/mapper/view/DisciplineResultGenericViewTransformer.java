package net.kodar.universityMVC.business.mapper.view;

import net.kodar.universityMVC.business.mapper.GenericViewTransformer;
import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.presentation.model.view.DisciplineView;
import org.springframework.stereotype.Component;

@Component
public class DisciplineResultGenericViewTransformer implements GenericViewTransformer<Discipline, DisciplineView> {
    @Override
    public DisciplineView apply(Discipline discipline) {
        DisciplineView disciplineView = new DisciplineView();
        disciplineView.setName(discipline.getName());
        disciplineView.setId(discipline.getId());

        return disciplineView;
    }
}
