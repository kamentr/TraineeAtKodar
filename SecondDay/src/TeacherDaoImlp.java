import java.util.ArrayList;

public class TeacherDaoImlp implements TeacherDao {

    protected ArrayList<Teacher> teacherData = TeacherData.teacherData;

    @Override
    public Teacher get(int id) {
        return teacherData.get(id);
    }

    @Override
    public ArrayList<Teacher> getAll() {
        return teacherData;
    }

    @Override
    public void save(Teacher teacher) {
        teacherData.add(teacher);
    }

    @Override
    public void update(Teacher teacher) {

        for(Teacher t: getAll()){
            if(t.getlName() == teacher.getlName() && t.getfName() == teacher.getfName()){
                t = teacher;
            }
        }

    }

    @Override
    public void delete(Teacher teacher) {
        for(Teacher t: getAll()){
            if(t.getlName() == teacher.getlName() && t.getfName() == teacher.getfName()){
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
