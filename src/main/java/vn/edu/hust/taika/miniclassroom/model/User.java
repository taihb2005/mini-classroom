package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name="school_user",
        indexes = {
                @Index(name="idx_user_id", columnList = "user_id", unique = true),
                @Index(name="idx_user_name", columnList = "username"),
                @Index(name="idx_full_name", columnList = "full_name"),
                @Index(name="idx_email", columnList = "email")
        }
)
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    protected Long userId;

    @Column(name = "username", unique = true, nullable = false)
    protected String username;

    @Column(name = "password_hash", nullable = false)
    protected String passwordHash;

    @Column(name = "full_name")
    protected String fullName;

    @Column(name = "email", unique = true)
    protected String email;

    @Column(name = "phone")
    protected String phone;

    @Column(name = "date_of_birth", nullable = false)
    protected Date dateOfBirth;

    @Column(name = "address")
    protected String address;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10)
    protected Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", length = 20)
    protected UserType userType;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    protected List<UserClassRole> assignedRoleToClass;

    public enum Gender {
        MALE, FEMALE, UNKNOWN;
    }

    public enum UserType {
        ADMIN, TEACHER, STUDENT
    }
}
