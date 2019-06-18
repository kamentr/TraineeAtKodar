package net.kodar.trainee;

import net.kodar.trainee.contracts.StudentTeacherDao;

import java.util.ArrayList;
import java.util.List;

public class StudentTeacherDaoImpl implements StudentTeacherDao {

    List<StudentTeacher> studentTeacher = new ArrayList<>();

    @Override
    public StudentTeacher get(int id) {
        return this.studentTeacher.get(id);
    }

    @Override
    public List<StudentTeacher> getAll() {
        return this.studentTeacher;
    }

    @Override
    public void save(StudentTeacher studentTeacher) {
        this.studentTeacher.add(studentTeacher);
    }

    @Override
    public void update(StudentTeacher studentTeacher) {
        for (StudentTeacher s : this.studentTeacher) {
            if(s.getTeacherId() == studentTeacher.getTeacherId() &&
                    s.getStudentId() == studentTeacher.getStudentId()){
                s = studentTeacher;
                break;
            }
        }
    }

    @Override
    public void delete(StudentTeacher studentTeacher) {
        this.studentTeacher.remove(studentTeacher);
    }

    @Override
    public void delete(int id) {
        this.studentTeacher.remove(id);
    }
}

