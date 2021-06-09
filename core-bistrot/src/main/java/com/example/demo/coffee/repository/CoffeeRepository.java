package com.example.demo.coffee.repository;

import com.example.demo.coffee.entity.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Long, CoffeeEntity> {
}
