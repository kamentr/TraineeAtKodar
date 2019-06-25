package net.kodar.trainee.business.processor.studentteacher;

import net.kodar.trainee.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDao;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoImpl;
import net.kodar.trainee.presentation.parameter.StudentTeacherParam;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    private List<StudentTeacher> studentTeacherList;
    private StudentTeacherDao studentTeacherDao = new StudentTeacherDaoImpl();
    private StudentTeacherResultGenericResultTransformer resultTransformer = new StudentTeacherResultGenericResultTransformer();
    private StudentTeacherParamGenericParamTransformer paramTransformer = new StudentTeacherParamGenericParamTransformer();

    public StudentTeacherProcessorImpl() {
        studentTeacherList = studentTeacherDao.getAll();
    }

    @Override
    public List<StudentTeacherResult> filterByStudent(Integer id) {

        return studentTeacherList
                .stream()
                .filter(student -> student.getStudentId() == id)
                .map(st->resultTransformer.apply(st))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherResult> filterByTeacher(Integer id) {
        return studentTeacherList
                .stream()
                .filter(teacher -> teacher.getTeacherId() == id)
                .map(st->resultTransformer.apply(st))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteStudent(int id) {

        studentTeacherList = studentTeacherList
                .stream()
                .filter(st -> st.getStudentId() != id)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteTeacher(int id) {

        List<StudentTeacher> filteredList = studentTeacherList
                .stream()
                .filter(st -> st.getTeacherId() != id)
                .collect(Collectors.toList());

        studentTeacherList = filteredList;
    }

    public StudentTeacherResult get(int id) {
        return resultTransformer.apply(studentTeacherDao.get(id));
    }

    public List<StudentTeacherResult> getAll() {
        List<StudentTeacher> studentTeacherList = studentTeacherDao.getAll();

        return studentTeacherList
                .stream()
                .map(st -> resultTransformer.apply(st))
                .collect(Collectors.toList());
    }

    @Override
    public void save(StudentTeacherParam t) {
        StudentTeacher studentTeacher = studentTeacherDao.get(t.getId());
        if(studentTeacher != null) {
            StudentTeacher studentTeacherToSave = paramTransformer.apply(t,null);
            studentTeacherDao.save(studentTeacherToSave);
        }else {
            //exception
        }
    }

    @Override
    public void update(StudentTeacherParam t) {
        StudentTeacher studentTeacher = studentTeacherDao.get(t.getId());

        if (studentTeacher != null) {
            StudentTeacher studentTeacherToUpdate = paramTransformer.apply(t,studentTeacher);
            studentTeacherDao.update(studentTeacherToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(StudentTeacherParam t) {
        StudentTeacher studentTeacher = studentTeacherDao.get(t.getId());
        if (studentTeacher != null) {
            StudentTeacher studentTeacherToDelete = paramTransformer.apply(t,studentTeacher);
            studentTeacherDao.delete(studentTeacherToDelete);
        } else {
            //exception
        }
    }

    @Override
    public void delete(int id) {
        studentTeacherDao.delete(id);
    }

}
