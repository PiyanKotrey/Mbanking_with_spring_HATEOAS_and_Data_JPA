package com.example.mobile_banking_with_spring_hateoas.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUuid(String uuid);
    @Modifying
    @Query("DELETE FROM User u WHERE u.uuid = :uuid")
    void deleteUserByUuid(String uuid);

}
