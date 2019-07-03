package net.kodar.university.business.processor.discipline;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGeneric;
import net.kodar.university.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGenericImpl;
import net.kodar.university.business.transformer.param.DisciplineParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.DisciplineResultGenericResultTransformer;
import net.kodar.university.business.validator.Discipline.DisciplineGenericValidatorImpl;
import net.kodar.university.data.entities.Discipline;
import net.kodar.university.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.DisciplineParam;
import net.kodar.university.presentation.depricated.result.DisciplineResult;
import net.kodar.university.presentation.depricated.result.StudentTeacherDisciplineResult;

import java.util.ArrayList;
import java.util.List;

public class DisciplineProcessorGenericImpl extends ProcessorGenericImpl
        <DisciplineParam, DisciplineResult, Integer, Discipline,
                DisciplineDaoGenericImpl,
                DisciplineParamGenericParamTransformer,
                DisciplineResultGenericResultTransformer,
                DisciplineGenericValidatorImpl>
        implements DisciplineProcessorGeneric
{

    private StudentTeacherDisciplineProcessorGeneric studentTeacherDisciplineProcessor;

    public DisciplineProcessorGenericImpl(){
        this.dao = new DisciplineDaoGenericImpl();
        this.ptr = new DisciplineParamGenericParamTransformer();
        this.rtr = new DisciplineResultGenericResultTransformer();
        this.val = new DisciplineGenericValidatorImpl();
        this.studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorGenericImpl();
    }

    @Override
    public List<DisciplineResult> getByStudentId(Integer id) {
        List<DisciplineResult> disciplineList = new ArrayList<>();
        List<StudentTeacherDisciplineResult> studentTeacherDisciplineList = studentTeacherDisciplineProcessor.getAll();

        studentTeacherDisciplineList
                .stream()
                .filter(s -> !s.getTeacherId().equals(id))
                .forEach(s -> {
                    Discipline discipline = dao.get(s.getDisciplineId());
                    disciplineList.add(rtr.apply(discipline));
                });

        return disciplineList;
    }

    @Override
    public List<DisciplineResult> getByTeacherId(Integer id) {
        List<DisciplineResult> disciplineList = new ArrayList<>();

        studentTeacherDisciplineProcessor
                .filterByTeacher(id)
                .forEach(d -> {
                    DisciplineResult filteredDiscipline = rtr.apply(dao.get(d.getDisciplineId()));
                    disciplineList.add(filteredDiscipline);
                });

        return disciplineList;
    }

    @Override
    public int getID(DisciplineParam entity) {
        return entity.getId();
    }
}
