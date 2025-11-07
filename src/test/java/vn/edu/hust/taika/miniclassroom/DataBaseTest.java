package vn.edu.hust.taika.miniclassroom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.edu.hust.taika.miniclassroom.config.JPAConfig;
import vn.edu.hust.taika.miniclassroom.config.SecurityConfig;
import vn.edu.hust.taika.miniclassroom.model.Operation;
import vn.edu.hust.taika.miniclassroom.model.Permission;
import vn.edu.hust.taika.miniclassroom.model.Role;
import vn.edu.hust.taika.miniclassroom.model.User;
import vn.edu.hust.taika.miniclassroom.repository.RoleRepository;
import vn.edu.hust.taika.miniclassroom.repository.UserRepository;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({JPAConfig.class, SecurityConfig.class})
class DataBaseTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldInsertAndFindUser() {
        User user = new User();
        user.setUsername("tai");
        user.setPasswordHash(passwordEncoder.encode("password"));
        user.setEmail("tai@example.com");
        user.setDateOfBirth(new Date());

        userRepository.save(user);

        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getUserId()).isNotNull();

        User found = userRepository.findUserByEmail("tai@example.com").orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("tai");
        assertThat(found.getPasswordHash()).isNotEqualTo("password");
        assertThat(passwordEncoder.matches("password", found.getPasswordHash())).isEqualTo(true);
    }

    @Test
    void shouldInsertRoleAndHasCorrespondingPermission(){
        Role role = new Role();
        role.setName(Role.RoleType.TEACHER_HOMEROOM);
        role.setScopeType(Role.ScopeType.CLASS);

        Permission permission1 = new Permission();
        permission1.setOperation(Operation.ADD_STUDENT);
        permission1.setRole(role);

        Permission permission2 = new Permission();
        permission2.setOperation(Operation.VIEW_STUDENTS);
        permission2.setRole(role);

        Permission permission3 = new Permission();
        permission3.setOperation(Operation.CREATE_CLASS);
        permission3.setRole(role);

        role.setPermissions(List.of(permission1, permission2, permission3));

        Role saved = roleRepository.save(role);

        Role found = roleRepository.findRoleByRoleId(saved.getRoleId()).orElse(null);
        assertThat(found).isNotNull();

        List<Permission> permissions = found.getPermissions();
        assertThat(permissions).isNotNull().isNotEmpty();

        assertThat(permissions.size()).isEqualTo(3);
        assertThat(permissions.getFirst().getOperation()).isEqualTo(Operation.ADD_STUDENT);
        assertThat(permissions.get(1).getOperation()).isEqualTo(Operation.VIEW_STUDENTS);
        assertThat(permissions.get(2).getOperation()).isEqualTo(Operation.CREATE_CLASS);
        assertThat(permissions.getFirst().getPermissionId()).isNotNull();
        assertThat(permissions.getFirst().getRole()).isNotNull();
        assertThat(permissions.getFirst().getRole().getRoleId()).isEqualTo(found.getRoleId());
    }
}

