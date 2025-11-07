package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id", nullable = false)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    private RoleType name;

    @Enumerated(EnumType.STRING)
    @Column(name="scope_type", updatable = false)
    private ScopeType scopeType;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Permission> permissions;

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserClassRole> rolesAssignedToUserInClass;

    public enum RoleType {
        ADMIN, TEACHER_HOMEROOM, TEACHER_SUBJECT, STUDENT
    }

    public enum ScopeType {
        GLOBAL,
        CLASS
    }
}
