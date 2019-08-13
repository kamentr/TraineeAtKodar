package net.kodar.universityMVC.business.service.discipline;

import net.kodar.universityMVC.business.service.Service;
import net.kodar.universityMVC.presentation.model.binding.DisciplineParam;
import net.kodar.universityMVC.presentation.model.view.DisciplineView;

import java.util.List;

@org.springframework.stereotype.Service
public interface DisciplineService extends Service<DisciplineParam, DisciplineView> {
    List<DisciplineView> getDisciplinesByStudentId(int studentId);
}
