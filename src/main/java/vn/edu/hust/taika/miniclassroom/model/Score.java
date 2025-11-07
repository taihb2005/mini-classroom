package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(
        name = "score",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"class_subject_id", "student_id", "assessment_type_id"})
        },
        indexes = {
                @Index(name = "idx_score_class_subject_id", columnList = "class_subject_id"),
                @Index(name = "idx_score_student_id", columnList = "student_id"),
                @Index(name = "idx_score_assessment_type_id", columnList = "assessment_type_id")
        }
)
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id", nullable = false, updatable = false)
    private Long scoreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_subject_id", nullable = false)
    private ClassSubject classSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_type_id", nullable = false)
    private AssessmentType assessmentType;

    @Column(name = "value", precision = 5, scale = 2, nullable = false)
    private BigDecimal value;

    @Column(name = "note", length = 500)
    private String note;
}
