package com.techeazy.may_batch4.repository;

import com.techeazy.may_batch4.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailAndPassword(String email,String password);
    UserEntity findByEmail(String email);

}
