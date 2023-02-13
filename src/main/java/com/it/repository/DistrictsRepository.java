package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.DistrictsEntity;

@Repository
public interface DistrictsRepository extends JpaRepository<DistrictsEntity, Integer>{

	@Query("select t from DistrictsEntity t where t.districtCode = ?1  ")
	public DistrictsEntity  findDistrict(String districtCode);
	
	
}