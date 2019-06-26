package net.kodar.trainee.dataaccess.dao.studenteacher;

import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.studenteacher.data.StudentTeacherDataMap;

import java.util.*;

public class StudentTeacherDaoImpl implements StudentTeacherDao {

    private StudentTeacherDataMap studentTeacherDataMap = new StudentTeacherDataMap();
    private Map<Integer, StudentTeacher> studentTeacher = studentTeacherDataMap.getStudentTeacherData();

    @Override
    public StudentTeacher get(int id) {
        return this.studentTeacher.get(id);
    }

    @Override
    public List<StudentTeacher> getAll() {
        return new ArrayList<>(studentTeacher.values());
    }

    @Override
    public StudentTeacher save(StudentTeacher studentTeacher) {
        this.studentTeacher.put(studentTeacher.getId(), studentTeacher);
        Collection<StudentTeacher> studentTeachers = this.studentTeacher.values();
        return studentTeachers
                .stream()
                .filter(st -> st.getIdentifier().equals(studentTeacher.getIdentifier()))
                .findFirst()
                .get();
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

