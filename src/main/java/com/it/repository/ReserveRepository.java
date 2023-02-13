package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.ReserveEntity;
import com.it.entity.UserEntity;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Integer>{
	
	@Query("select t from ReserveEntity t where t.reserveId=?1 ")
	public ReserveEntity findByreserveId(Integer reserveId);
	
	@Query("select t from ReserveEntity t where t.recordStatus=?1 ")
    public List<ReserveEntity>  getByrecord(String recordStatus);
	
	@Query("select t from ReserveEntity t where t.svcId=?1 and t.recordStatus = ?2 ")
    public List<ReserveEntity>  getBySvcId(Integer svcId, String recordStatus);
	
	@Query("select t from ReserveEntity t where t.userId=?1 and t.recordStatus = ?2")
    public List<ReserveEntity>  getByUserId(Integer userId, String recordStatus);

}
