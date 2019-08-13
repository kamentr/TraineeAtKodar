package net.kodar.universityMVC.presentation.model.view;

import java.util.List;

public class StudentDetailsView {
    private StudentView student;

    private List<TeacherView> teacherList;

    private List<DisciplineView> disciplineList;


    public StudentView getStudent() {
        return student;
    }

    public void setStudent(StudentView student) {
        this.student = student;
    }

    public List<TeacherView> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherView> teacherList) {
        this.teacherList = teacherList;
    }

    public List<DisciplineView> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<DisciplineView> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
