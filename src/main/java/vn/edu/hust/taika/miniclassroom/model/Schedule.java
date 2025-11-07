package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "schedule",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"class_subject_id", "day_of_week", "session", "period"})
        },
        indexes = {
                @Index(name = "idx_schedule_class_subject_id", columnList = "class_subject_id")
        }
)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false, updatable = false)
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_subject_id", nullable = false)
    private ClassSubject classSubject;

    @Column(name = "day_of_week", nullable = false)
    private Integer dayOfWeek; // 1 = Monday, 7 = Sunday

    @Enumerated(EnumType.STRING)
    @Column(name = "session", nullable = false, length = 20)
    private SessionType session;

    @Column(name = "period", nullable = false)
    private Integer period;

    @Column(name = "room", length = 100)
    private String room;

    public enum SessionType {
        MORNING, AFTERNOON
    }
}
