package vn.edu.hust.taika.miniclassroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hust.taika.miniclassroom.model.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(Role.RoleType roleType);
    Optional<Role> findRoleByRoleId(Long roleId);
}
