package net.kodar.trainee.dataАccess.dao.studentTeacher;

import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataАccess.dao.studentTeacher.data.StudentTeacherDataMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentTeacherDaoImpl implements StudentTeacherDao {

    Map<Integer, StudentTeacher> studentTeacher = StudentTeacherDataMap.studentTeacherData;
    StudentTeacherDataMap studentTeacherDataMap = new StudentTeacherDataMap();


    @Override
    public StudentTeacher get(int id) {
        return this.studentTeacher.get(id);
    }

    @Override
    public List<StudentTeacher> getAll() {
        return new ArrayList<>(studentTeacher.values());
    }

    @Override
    public void save(StudentTeacher studentTeacher) {
        this.studentTeacher.put(studentTeacher.getId(), studentTeacher);
    }

    @Override
    public void update(StudentTeacher studentTeacher) {
        for (StudentTeacher s : this.studentTeacher.values()) {
            if(Objects.equals(s.getTeacherId(), studentTeacher.getTeacherId()) &&
                    Objects.equals(s.getStudentId(), studentTeacher.getStudentId())){
                s = studentTeacher;
                break;
            }
        }
    }

    @Override
    public void delete(StudentTeacher studentTeacher) {
        this.studentTeacher.remove(studentTeacher.getId());
    }

    @Override
    public void delete(int id) {
        this.studentTeacher.remove(id);
    }
}

