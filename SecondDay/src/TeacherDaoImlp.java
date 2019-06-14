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
    public void update(Teacher teacher, String[] params) {
        if(teacherData.contains(teacher)){
            teacher.setfName(params[0]);
            teacher.setlName(params[1]);
        }
    }

    @Override
    public void delete(Teacher teacher) {
        if(teacherData.contains(teacher)){
            teacherData.remove(teacher);
        }
    }
}
