package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.it.entity.UserDetailEntity;
//import com.it.entity.UserEntity;
import com.it.entity.WorkEntity;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Integer> {
	
	@Query("select t from WorkEntity t where t.recordStatus=?1 ")
    public List<WorkEntity>  getByrecord(String recordStatus);
	
	@Query("select t from WorkEntity t where t.svcId=?1")
    public List<WorkEntity>  getBySvcId(Integer svcId);
	


}
