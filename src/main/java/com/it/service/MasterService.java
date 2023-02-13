package com.it.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.AmphuresDTO;
import com.it.dto.DistrictsDTO;
import com.it.dto.ProvincesDTO;
import com.it.dto.ZipcodesDTO;
import com.it.entity.AmphuresEntity;
import com.it.entity.DistrictsEntity;
import com.it.entity.ProvincesEntity;
import com.it.entity.ZipcodesEntity;
import com.it.repository.AmphuresRepository;
import com.it.repository.DistrictsRepository;
import com.it.repository.ProvincesRepository;
import com.it.repository.ZipcodesRepository;

@Service
public class MasterService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProvincesRepository provincesRepository;

	@Autowired
	private AmphuresRepository amphuresRepository;

	@Autowired
	private DistrictsRepository districtsRepository;

	@Autowired
	private ZipcodesRepository zipcodesRepository;

	public ProvincesDTO findProvincesByProvinceId(Integer provinceId) {

		Optional<ProvincesEntity> entity = provincesRepository.findById(provinceId);

		if(entity.isPresent()) {
			return modelMapper.map(entity.get(), new TypeToken<ProvincesDTO>() {}.getType());
		}

		return null; 
	}

	public AmphuresDTO findAmphuresByAmphuresId(Integer amphuresId) {

		Optional<AmphuresEntity> entity = amphuresRepository.findById(amphuresId);

		if(entity.isPresent()) {
			return modelMapper.map(entity.get(), new TypeToken<AmphuresDTO>() {}.getType());
		}

		return null; 
	}

	public DistrictsDTO findDistrictsByDistrictsId(String districtsId) {

		DistrictsEntity entity = districtsRepository.findDistrict(districtsId);

		if(null != entity) {
			return modelMapper.map(entity, new TypeToken<DistrictsDTO>() {}.getType());
		}

		return null; 
		
	}

	public ZipcodesDTO findZipcodesByZipcodesId(String zipcodesId) {

		ZipcodesEntity entity = zipcodesRepository.findZipCode(zipcodesId);
		
		if(null != entity) {
			return modelMapper.map(entity, new TypeToken<ZipcodesDTO>() {}.getType());
		}

		return null; 
		
	}
}
