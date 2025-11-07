package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "enrollment_class_subject",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"class_subject_id", "student_id"})
        },
        indexes = {
                @Index(name = "idx_enroll_class_subject_class_subject_id", columnList = "class_subject_id"),
                @Index(name = "idx_enroll_class_subject_student_id", columnList = "student_id")
        }
)
@EntityListeners(AuditingEntityListener.class)
public class EnrollmentClassSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enroll_cs_id", nullable = false, updatable = false)
    private Long enrollCsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_subject_id", nullable = false)
    private ClassSubject classSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @CreatedDate
    @Column(name = "joined_at", nullable = false, updatable = false)
    private LocalDateTime joinedAt;
}
