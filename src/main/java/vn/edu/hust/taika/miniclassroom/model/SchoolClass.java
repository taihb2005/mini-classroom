package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "school_class")
public class SchoolClass {
    @Id
    @Column(name = "class_id", nullable = false, unique = true, updatable = false)
    private Long classId;

    @Column(name="class_name")
    private String className;

    @Column(name="grade")
    private int grade;

    @Column(name="school_year")
    private String schoolYear;

    @Column(name="semester")
    private String semester;

    @Column(name="is_homeroom")
    private boolean isHomeroom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Teacher homeroomTeacher;

    @CreatedDate
    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name="created_by", nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name="updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "classId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserClassRole> classRolesAssignedTo;

    @OneToMany(mappedBy = "classId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<EnrollmentClass> enrollmentsAssignedToClass;

    @OneToMany(mappedBy = "classId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ClassSubject> classSubjectsAssignedTo;
}
