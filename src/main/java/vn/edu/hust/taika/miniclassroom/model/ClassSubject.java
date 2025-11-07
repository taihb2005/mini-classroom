package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "class_subject")
public class ClassSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_subject_id", nullable = false, updatable = false)
    private Long classSubjectId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass classId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Teacher teacherId;
}
