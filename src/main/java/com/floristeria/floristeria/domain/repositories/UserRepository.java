package com.floristeria.floristeria.domain.repositories;

import com.floristeria.floristeria.domain.entities.UserEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
