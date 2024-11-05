package org.example.sd_94vs1.repository;



import org.example.sd_94vs1.entity.User;
import org.example.sd_94vs1.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(UserRole userRole);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    List<User> findByUserCode(String userCode);

}