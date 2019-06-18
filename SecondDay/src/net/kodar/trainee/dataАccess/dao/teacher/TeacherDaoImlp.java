package net.kodar.trainee.dataАccess.dao.teacher;

import net.kodar.trainee.dataАccess.dao.teacher.data.TeacherData;
import net.kodar.trainee.data.entities.Teacher;

import java.util.List;
import java.util.Objects;

public class TeacherDaoImlp implements TeacherDao {

    protected List<Teacher> teacherData = TeacherData.teacherData;


    @Override
    public Teacher get(int id) {
        return teacherData.get(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherData;
    }

    @Override
    public void save(Teacher teacher) {
        teacherData.add(teacher);
    }

    @Override
    public void update(Teacher teacher) {

        for(Teacher t: getAll()){
            if(Objects.equals(t.getlName(), teacher.getlName()) && Objects.equals(t.getfName(), teacher.getfName())){
                t = teacher;
            }
        }

    }

    @Override
    public void delete(Teacher teacher) {
        for(Teacher t: getAll()){
            if(Objects.equals(t.getlName(), teacher.getlName()) && Objects.equals(t.getfName(), teacher.getfName())){
                getAll().remove(t);
            }
        }
    }

    @Override
    public void delete(int id) {
        for(Teacher t: getAll()){
            if(t.getId() == id){
                getAll().remove(t);
            }
        }
    }
}
