package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "enrollment_class")
public class EnrollmentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enroll_class_id", nullable = false, updatable = false)
    private Long enrollClassId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass classId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Student studentId;

    @Column(name = "joined_at")
    private LocalDateTime joinedAt;
}
