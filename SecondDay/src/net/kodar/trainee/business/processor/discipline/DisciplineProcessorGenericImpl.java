package net.kodar.trainee.business.processor.discipline;

import net.kodar.trainee.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGeneric;
import net.kodar.trainee.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorGenericImpl;
import net.kodar.trainee.business.transformer.result.DisciplineResultGenericResultTransformer;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoGeneric;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoGenericImpl;
import net.kodar.trainee.presentation.parameter.DisciplineParam;
import net.kodar.trainee.presentation.result.DisciplineResult;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

import java.util.ArrayList;
import java.util.List;

public class DisciplineProcessorGenericImpl extends DisciplineProcessorGeneric {

    private DisciplineDaoGeneric disciplineDao = new DisciplineDaoGenericImpl();
    private StudentTeacherDisciplineProcessorGeneric studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorGenericImpl();
    private DisciplineResultGenericResultTransformer disciplineResult = new DisciplineResultGenericResultTransformer();

    @Override
    public List<DisciplineResult> getByStudentId(Integer id) {
        List<DisciplineResult> disciplineList = new ArrayList<>();
        List<StudentTeacherDisciplineResult> studentTeacherDisciplineList = studentTeacherDisciplineProcessor.getAll();

        studentTeacherDisciplineList
                .stream()
                .filter(s -> !s.getTeacherId().equals(id))
                .forEach(s -> {
                    Discipline discipline = disciplineDao.get(s.getDisciplineId());
                    disciplineList.add(disciplineResult.apply(discipline));
                });

        return disciplineList;
    }

    @Override
    public List<DisciplineResult> getByTeacherId(Integer id) {
        List<DisciplineResult> disciplineList = new ArrayList<>();

        studentTeacherDisciplineProcessor
                .filterByTeacher(id)
                .forEach(d -> {
                    DisciplineResult filteredDiscipline = disciplineResult.apply(disciplineDao.get(d.getDisciplineId()));
                    disciplineList.add(filteredDiscipline);
                });

        return disciplineList;
    }

    @Override
    public int getID(DisciplineParam entity) {
        return entity.getId();
    }
}
