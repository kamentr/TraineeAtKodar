package net.kodar.trainee.dataaccess.dao.studentteacherdiscipline;

import net.kodar.trainee.data.entities.StudentTeacherDiscipline;
import net.kodar.trainee.dataaccess.dao.studentteacherdiscipline.data.StudentTeacherDisciplineData;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class StudentTeacherDisciplineDaoGenericImpl extends StudentTeacherDisciplineDaoGeneric {
    @Override
    protected Integer getId(StudentTeacherDiscipline studentTeacherDiscipline) {
        return studentTeacherDiscipline.getId();
    }

    @Override
    protected StudentTeacherDiscipline getByIdentifier(StudentTeacherDiscipline studentTeacherDiscipline) {
        Collection<StudentTeacherDiscipline> list = getData().values();
        return list
                .stream()
                .filter(std -> getIdentifier(std).equals(getIdentifier(studentTeacherDiscipline)))
                .findFirst()
                .get();
    }

    @Override
    protected UUID getIdentifier(StudentTeacherDiscipline studentTeacherDiscipline) {
        return studentTeacherDiscipline.getIdentifier();
    }

    @Override
    protected Map<Integer, StudentTeacherDiscipline> getData() {
        StudentTeacherDisciplineData studentTeacherDisciplineData = new StudentTeacherDisciplineData();
        return studentTeacherDisciplineData.getStudentTeacherDisciplineMap();
    }
}
