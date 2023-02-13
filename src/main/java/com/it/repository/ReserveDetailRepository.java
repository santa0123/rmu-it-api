package com.it.repository;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.ReserveDetailEntity;
import com.it.entity.UserDetailEntity;

@Repository
public interface ReserveDetailRepository extends JpaRepository<ReserveDetailEntity, Integer>{
	
	@Query("select t from ReserveDetailEntity t where t.reserveId=?1 ")
	public List<ReserveDetailEntity> findByReserveId(Integer reserveId);
	
	@Query("select t from ReserveDetailEntity t where t.recordStatus=?1 ")
    public List<ReserveDetailEntity>  getByrecord(String recordStatus);
	
	@Query("select t from ReserveDetailEntity t where t.bookStartDate=?1 ")
	public ReserveDetailEntity findByBookStartDate(Timestamp bookStartDate);
	
	@Query("select t from ReserveDetailEntity t where DATE(t.bookStartDate) = ?1 ")
	public List<ReserveDetailEntity> findBySerach(Date startDate);

}
