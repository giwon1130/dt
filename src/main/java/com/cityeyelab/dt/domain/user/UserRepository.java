package com.cityeyelab.dt.domain.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    Optional<User> findByUserRole(UserRole userRole);

    void deleteById(Long userNo);

    Page<User> findByUserIdContaining(String userId, Pageable pageable);

    long countByMasterId(String masterId);
}
