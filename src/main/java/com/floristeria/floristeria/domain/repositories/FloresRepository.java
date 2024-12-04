package com.floristeria.floristeria.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.floristeria.floristeria.domain.entities.FloresEntity;

@Repository
public interface FloresRepository extends JpaRepository<FloresEntity, Long> {
    List<FloresEntity> findAllByUserId(int user_id);

    FloresEntity findOneByUserId(int user_id);
}
