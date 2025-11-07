package vn.edu.hust.taika.miniclassroom.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hust.taika.miniclassroom.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(Long userId);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
}
