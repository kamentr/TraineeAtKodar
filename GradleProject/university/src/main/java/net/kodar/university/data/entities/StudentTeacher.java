package net.kodar.university.data.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class StudentTeacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "ID")
    private Integer studentId;

    @JoinColumn(name = "id")
    private Integer teacherId;
    private UUID identifier;

    public StudentTeacher(int id, int studentId, int teacherId) {
        this.setStudentId(studentId);
        this.setTeacherId(teacherId);
        this.setId(id);
        this.setIdentifier(UUID.randomUUID());
    }
    public StudentTeacher(){
        this.setIdentifier(UUID.randomUUID());
    }

    public StudentTeacher(int studentId, int teacherId) {
        this.setStudentId(studentId);
        this.setTeacherId(teacherId);
        this.setIdentifier(UUID.randomUUID());
    }

    public UUID getIdentifier() {
        return identifier;
    }

    private void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
