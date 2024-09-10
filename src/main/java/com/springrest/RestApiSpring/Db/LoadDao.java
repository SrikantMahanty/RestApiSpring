package com.springrest.RestApiSpring.Db;

import com.springrest.RestApiSpring.Entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadDao  extends JpaRepository<Load,UUID> {
    // Custom query method to find loads by shipperId
    List<Load> findByShipperId(UUID shipperId);
}
