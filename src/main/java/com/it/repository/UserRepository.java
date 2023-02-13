package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.entity.UserEntity;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("select t from UserEntity t where t.username = ?1 and  t.password  = ?2  ")
    public UserEntity  getByUserNamePassword(String username, String password);

	@Query("select t from UserEntity t where t.roleId=?1")
    public List<UserEntity>  getByAllroleId(Integer roleId);
	
	@Query("select t from UserEntity t where t.recordStatus=?1 ")
    public List<UserEntity>  getByAllrecord(String recordStatus);
	
	@Query("select t from UserEntity t where t.roleId=?1 and t.recordStatus = ?2")
    public List<UserEntity>  getByRoleId(Integer roleId, String recordStatus);
	
	@Query("select t from UserEntity t where t.username = ?1 ")
    public UserEntity  getByUserName(String username);
	
	@Query("select t from UserEntity t where t.username = ?1 ")
    public List<UserEntity>  sechByUserName(String username);
	
	@Modifying
    @Query(value = "delete from UserEntity t  where t.userId = ?1")
    void deleteByuserId(Integer userId);


}
