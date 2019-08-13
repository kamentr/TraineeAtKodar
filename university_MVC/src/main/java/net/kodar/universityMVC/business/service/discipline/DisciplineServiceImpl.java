package net.kodar.universityMVC.business.service.discipline;

import net.kodar.universityMVC.business.service.ServiceImpl;
import net.kodar.universityMVC.business.mapper.binding.DisciplineParamGenericBindingTransformer;
import net.kodar.universityMVC.business.mapper.view.DisciplineResultGenericViewTransformer;
import net.kodar.universityMVC.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.universityMVC.data.entities.Discipline;
import net.kodar.universityMVC.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.universityMVC.presentation.model.binding.DisciplineParam;
import net.kodar.universityMVC.presentation.model.view.DisciplineView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DisciplineServiceImpl extends ServiceImpl
        <DisciplineParam, DisciplineView, Integer, Discipline,
                DisciplineDaoGenericImpl,
                DisciplineParamGenericBindingTransformer,
                DisciplineResultGenericViewTransformer,
                DisciplineGenericValidatorImpl>
        implements DisciplineService
{
    @Override
    public int getID(DisciplineParam entity) {
        return entity.getId();
    }

    @Override
    public List<DisciplineView> getDisciplinesByStudentId(int studentId) {
        return this.dao.getDisciplinesByStudentId(studentId).stream().map(this.rtr).collect(Collectors.toList());
    }
}
