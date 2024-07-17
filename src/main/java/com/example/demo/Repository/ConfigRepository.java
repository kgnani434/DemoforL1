package com.example.demo.Repository;

import com.example.demo.Entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {
    ConfigEntity findByKey(String key);
}
