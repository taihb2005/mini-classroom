package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="user_class_role")
public class UserClassRole {
    @Id
    @Column(name="user_class_role_id", nullable = false, updatable = false)
    private Long userClassRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private SchoolClass classId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role roleId;

    @CreatedDate
    @Column(name="assigned_at", nullable = false, updatable = false)
    private LocalDateTime assignedAt;

    @LastModifiedDate
    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;
}
