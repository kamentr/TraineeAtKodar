package net.kodar.trainee.business.processor.discipline;

import net.kodar.trainee.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessor;
import net.kodar.trainee.business.processor.studentteacherdiscipline.StudentTeacherDisciplineProcessorImpl;
import net.kodar.trainee.business.transformer.param.DisciplineParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.DisciplineResultGenericResultTransformer;
import net.kodar.trainee.data.entities.Discipline;
import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDao;
import net.kodar.trainee.dataaccess.dao.discipline.DisciplineDaoImpl;
import net.kodar.trainee.presentation.parameter.DisciplineParam;
import net.kodar.trainee.presentation.result.DisciplineResult;
import net.kodar.trainee.presentation.result.StudentTeacherDisciplineResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisciplineProcessorImpl implements DisciplineProcessor {

    private DisciplineDao disciplineDao = new DisciplineDaoImpl();
    private StudentTeacherDisciplineProcessor studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorImpl();
    private DisciplineParamGenericParamTransformer disciplineParam = new DisciplineParamGenericParamTransformer();
    private DisciplineResultGenericResultTransformer disciplineResult = new DisciplineResultGenericResultTransformer();


    @Override
    public DisciplineResult get(int id) {
        DisciplineResult discipline = disciplineResult.apply(disciplineDao.get(id));
        return discipline;
    }

    @Override
    public List<DisciplineResult> getAll() {
        List<Discipline> disciplineList = disciplineDao.getAll();

        return disciplineList
                .stream()
                .map(d -> disciplineResult.apply(d))
                .collect(Collectors.toList());
    }

    @Override
    public DisciplineParam save(DisciplineParam discipline) {
        Discipline disciplineToSave = disciplineParam.apply(discipline, null);
        disciplineDao.save(disciplineToSave);
        return discipline;
    }

    @Override
    public void update(DisciplineParam discipline) {
        Discipline input = disciplineDao.get(discipline.getId());

        if (input != null) {
            Discipline disciplineToUpdate = disciplineParam.apply(discipline, input);
            disciplineDao.update(disciplineToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(DisciplineParam discipline) {
        Discipline disciplineParamToDelete = disciplineDao.get(discipline.getId());

        if (disciplineParamToDelete != null) {
            Discipline disciplineToDelete = disciplineParam.apply(discipline, disciplineParamToDelete);
            disciplineDao.delete(disciplineToDelete);
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        disciplineDao.delete(id);
    }

    @Override
    public List<DisciplineResult> getByStudentId(Integer id) {
        List<DisciplineResult> disciplineList = new ArrayList<>();
        List<StudentTeacherDisciplineResult> studentTeacherDisciplineList = studentTeacherDisciplineProcessor.getAll();

        studentTeacherDisciplineList
                .stream()
                .filter(s -> s.getTeacherId() != id)
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
}
