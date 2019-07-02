package net.kodar.university.business.processor.studentteacher;

import net.kodar.university.business.processor.ProcessorGenericImpl;
import net.kodar.university.business.transformer.param.StudentTeacherParamGenericParamTransformer;
import net.kodar.university.business.transformer.result.StudentTeacherResultGenericResultTransformer;
import net.kodar.university.business.validator.StudentTeacher.StudentTeacherGenericValidatorImpl;
import net.kodar.university.data.entities.StudentTeacher;
import net.kodar.university.dataaccess.dao.studenteacher.StudentTeacherDaoGeneric;
import net.kodar.university.dataaccess.dao.studenteacher.StudentTeacherDaoGenericImpl;
import net.kodar.university.presentation.depricated.parameter.StudentTeacherParam;
import net.kodar.university.presentation.depricated.result.StudentTeacherResult;

import java.util.List;
import java.util.stream.Collectors;

public class StudentTeacherProcessorGenericImpl extends ProcessorGenericImpl
        <StudentTeacherParam,
                StudentTeacherResult,
                Integer,
                StudentTeacher,
                StudentTeacherDaoGeneric,
                StudentTeacherParamGenericParamTransformer,
                StudentTeacherResultGenericResultTransformer,
                StudentTeacherGenericValidatorImpl>
        implements StudentTeacherProcessorGeneric {

    private List<StudentTeacher> studentTeacherList;

    public StudentTeacherProcessorGenericImpl(){
        this.dao = new StudentTeacherDaoGenericImpl();
        this.ptr = new StudentTeacherParamGenericParamTransformer();
        this.rtr = new StudentTeacherResultGenericResultTransformer();
        this.val = new StudentTeacherGenericValidatorImpl();
    }
    @Override
    public List<StudentTeacherResult> filterByStudent(Integer id) {
        return studentTeacherList
                .stream()
                .filter(student -> student.getStudentId().equals(id))
                .map(st -> rtr.apply(st))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentTeacherResult> filterByTeacher(Integer id) {
        return studentTeacherList
                .stream()
                .filter(teacher -> teacher.getTeacherId().equals(id))
                .map(st -> rtr.apply(st))
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

    @Override
    public int getID(StudentTeacherParam entity) {
        return entity.getId();
    }
}
