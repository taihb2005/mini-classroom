package vn.edu.hust.taika.miniclassroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="permission_id")
    private Long permissionId;

    @Enumerated(EnumType.STRING)
    @Column(name="operation", updatable = false, nullable = false)
    private Operation operation;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
}
