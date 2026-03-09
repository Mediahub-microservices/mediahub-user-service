package com.mediahub.user_service.repository;

import com.mediahub.user_service.domain.AppUser;
import com.mediahub.user_service.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    Optional<AppUser> findByEmail(String email);

    List<AppUser> findByRole(Role role);
}
