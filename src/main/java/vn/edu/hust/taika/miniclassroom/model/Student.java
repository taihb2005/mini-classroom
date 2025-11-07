package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{
    @Column(name="student_code", nullable=false, unique=true)
    private String studentCode;

    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<EnrollmentClass> enrollToClasses;
}
