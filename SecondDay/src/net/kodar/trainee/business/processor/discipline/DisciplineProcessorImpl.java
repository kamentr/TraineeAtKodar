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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DisciplineProcessorImpl implements DisciplineProcessor {

    DisciplineDao disciplineDao = new DisciplineDaoImpl();
    StudentTeacherDisciplineProcessor studentTeacherDisciplineProcessor = new StudentTeacherDisciplineProcessorImpl();
    DisciplineParamGenericParamTransformer disciplineParam = new DisciplineParamGenericParamTransformer();
    DisciplineResultGenericResultTransformer disciplineResult = new DisciplineResultGenericResultTransformer();


    @Override
    public DisciplineResult get(int id) {
        return disciplineResult.apply(disciplineDao.get(id));
    }

    @Override
    public List<DisciplineResult> getAll() {
        Stream<Discipline> disciplineStream = disciplineDao.getAll().stream();

        return disciplineStream
                .map(d -> disciplineResult.apply(d))
                .collect(Collectors.toList());
    }

    @Override
    public void save(DisciplineParam discipline) {
        disciplineDao.save(disciplineParam.apply(discipline, null));
    }

    @Override
    public void update(DisciplineParam discipline) {
        Discipline discipline1 = disciplineDao.get(discipline.getId());

        if (discipline != null) {
            disciplineDao.update(disciplineParam.apply(discipline, discipline1));
        } else {
            //exception
        }
    }

    @Override
    public void delete(DisciplineParam discipline) {
        Discipline d = disciplineDao.get(discipline.getId());
        if (d != null) {
            disciplineDao.delete(disciplineParam.apply(discipline, d));
        }else {
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
        Stream<StudentTeacherDiscipline> studentTeacherDisciplineStream = studentTeacherDisciplineProcessor.getAll().stream();

        studentTeacherDisciplineStream
                .filter(s -> s.getTeacherId() == id)
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
                .forEach(discipline ->{
                            Discipline disciplineiId = disciplineDao.get(discipline.getDisciplineId());
                            disciplineList.add(disciplineResult.apply(disciplineiId));
                        });

        return disciplineList;
    }
}
