package net.kodar.universityUI.presentation.model.result;

import java.util.List;

public class StudentDetailsView {
    private StudentResult student;

    private List<TeacherResult> teacherList;

    private List<DisciplineResult> disciplineList;


    public StudentResult getStudent() {
        return student;
    }

    public void setStudent(StudentResult student) {
        this.student = student;
    }

    public List<TeacherResult> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherResult> teacherList) {
        this.teacherList = teacherList;
    }

    public List<DisciplineResult> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<DisciplineResult> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
