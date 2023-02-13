package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.ReviewEntity;
import com.it.entity.UserEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	
	@Query("select t from ReviewEntity t where t.svcId=?1")
    public List<ReviewEntity>  getByAllreviewId(Integer svcId);

}
