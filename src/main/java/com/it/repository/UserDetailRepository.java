package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.entity.ReserveDetailEntity;
import com.it.entity.UserDetailEntity;

@Transactional
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Integer> {

	@Query("select t from UserDetailEntity t where t.userId=?1 ")
	public UserDetailEntity findByUserId(Integer userId);
	
	@Query("select t from UserDetailEntity t where t.userId=?1 ")
	public List<UserDetailEntity> findByLIstUserId(Integer userId);
	
	@Query("select t from UserDetailEntity t where t.recordStatus=?1 ")
    public List<UserDetailEntity>  getByAllrecord(String recordStatus);
	
	@Query("select t from UserDetailEntity t where t.svcId=?1 ")
	public UserDetailEntity findBySvcId(Integer SvcId);
	
	@Query("select t from UserDetailEntity t where t.svcName like %?1% ")
	public List<UserDetailEntity> findBySerach(String svcName);
	
	@Query("select t from UserDetailEntity t inner join ProvincesEntity p on p.provinceId = t.provinceId where p.provinceNameTh like %?1% and t.svcId <> 0 ")
	public List<UserDetailEntity> findBySerachProvine(String provinceNameTh);
	
	@Modifying
    @Query(value = "delete from UserDetailEntity t  where t.userId = ?1")
    void deleteByuserId(Integer userId);
	
	@Query("select t from UserDetailEntity t where t.fristName like %?1% ")
	public List<UserDetailEntity> findBySerachFnameLname(String fristName);

}
