package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.ProvincesEntity;
import com.it.entity.UserDetailEntity;

@Repository
public interface ProvincesRepository extends JpaRepository<ProvincesEntity, Integer>{

	@Query("select t from ProvincesEntity t where t.provinceNameTh like %?1% ")
	public List<ProvincesEntity> findBySerachProvine(String provinceNameTh);
}
