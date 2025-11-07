package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="teacher")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User{
    @Column(name="teacher_code", nullable=false, unique = true)
    private String teacherCode;

    @Column(name="department")
    private String department;

    @Column(name="specialization")
    private String specialization;

    @Column(name="degree")
    private String degree;

    @OneToOne(mappedBy = "homeroomTeacher", cascade = CascadeType.ALL)
    private SchoolClass homeroomToward;

    @OneToMany(mappedBy = "teacherId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ClassSubject> teachesSubjectsAssignedToClass;
}
