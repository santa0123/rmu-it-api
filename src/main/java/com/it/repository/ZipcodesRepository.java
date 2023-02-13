package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.ZipcodesEntity;

@Repository
public interface ZipcodesRepository extends JpaRepository<ZipcodesEntity, String>{

	@Query("select t from ZipcodesEntity t where t.zipcodes = ?1  ")
	public ZipcodesEntity  findZipCode(String zipcodes);
}
