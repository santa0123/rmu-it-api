package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.AmphuresEntity;

@Repository
public interface AmphuresRepository extends JpaRepository<AmphuresEntity, Integer>{

}
