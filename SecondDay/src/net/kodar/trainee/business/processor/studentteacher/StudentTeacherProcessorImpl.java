package net.kodar.trainee.business.processor.studentteacher;

import net.kodar.trainee.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.trainee.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.trainee.data.entities.StudentTeacher;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDao;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoGenericImpl;
import net.kodar.trainee.dataaccess.dao.studenteacher.StudentTeacherDaoImpl;
import net.kodar.trainee.presentation.parameter.StudentTeacherParam;
import net.kodar.trainee.presentation.result.StudentTeacherResult;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherProcessorImpl implements StudentTeacherProcessor {

    private List<StudentTeacher> studentTeacherList;
    private StudentTeacherDaoGeneric studentTeacherDao = new StudentTeacherDaoGenericImpl();
    private StudentTeacherResultGenericResultTransformer resultTransformer = new StudentTeacherResultGenericResultTransformer();
    private StudentTeacherParamGenericParamTransformer paramTransformer = new StudentTeacherParamGenericParamTransformer();

    public StudentTeacherProcessorImpl() {
        studentTeacherList = studentTeacherDao.getAll();
    }

    @Override
    public List<StudentTeacherResult> filterByStudent(Integer id) {

        return studentTeacherList
                .stream()
                .filter(student -> student.getStudentId().equals(id))
                .map(st -> resultTransformer.apply(st))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherResult> filterByTeacher(Integer id) {
        return studentTeacherList
                .stream()
                .filter(teacher -> teacher.getTeacherId().equals(id))
                .map(st -> resultTransformer.apply(st))
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
                .filter(st -> st.getTeacherId() == id)
                .collect(Collectors.toList());

        studentTeacherList = filteredList;
    }

    public StudentTeacherResult get(int id) {
        StudentTeacherResult studentTeacherResult = resultTransformer.apply(studentTeacherDao.get(id));
        return studentTeacherResult;
    }

    public List<StudentTeacherResult> getAll() {
        List<StudentTeacher> studentTeacherList = studentTeacherDao.getAll();

        return studentTeacherList
                .stream()
                .map(st -> resultTransformer.apply(st))
                .collect(Collectors.toList());
    }

    @Override
    public StudentTeacherResult save(StudentTeacherParam std) {
        StudentTeacher studentTeacherToSave = paramTransformer.apply(std, null);
        StudentTeacher save = studentTeacherDao.save(studentTeacherToSave);
        return resultTransformer.apply(save);
    }

    @Override
    public void update(StudentTeacherParam std) {
        StudentTeacher studentTeacher = studentTeacherDao.get(std.getId());

        if (studentTeacher != null) {
            StudentTeacher studentTeacherToUpdate = paramTransformer.apply(std, studentTeacher);
            studentTeacherDao.update(studentTeacherToUpdate);
        } else {
            //exception
        }
    }

    @Override
    public void delete(StudentTeacherParam std) {
        StudentTeacher studentTeacher = studentTeacherDao.get(std.getId());
        if (studentTeacher != null) {
            StudentTeacher studentTeacherToDelete = paramTransformer.apply(std, studentTeacher);
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
