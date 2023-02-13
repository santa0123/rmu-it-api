package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.BookingDto;
import com.it.dto.UserDataDto;
import com.it.dto.UserDetailDto;
import com.it.entity.AmphuresEntity;
import com.it.entity.DistrictsEntity;
import com.it.entity.ProvincesEntity;
import com.it.entity.ReserveEntity;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.entity.WorkEntity;
import com.it.repository.AmphuresRepository;
import com.it.repository.DistrictsRepository;
import com.it.repository.ProvincesRepository;
import com.it.repository.UserDetailRepository;
import com.it.repository.UserRepository;

@Service
public class UserDataService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserDetailRepository userdetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProvincesRepository provinRepository;
	
	@Autowired
	private AmphuresRepository ampRepository;
	
	@Autowired
	private DistrictsRepository adeRepository;
	
	public boolean updateUserDetailByUserId(Integer userId, UserDetailDto userDetailDTO) {
        boolean updateFlg  = false;
        try {
        	List<UserDetailEntity> userde = userdetailRepository.findByLIstUserId(userId);
            if (!userde.isEmpty()) {
            	
            	Optional<UserEntity> reserve = userRepository.findById(userId);
            	
            	if(reserve.isPresent()) {
            		reserve.get().setRecordStatus(userDetailDTO.getRecordStatus());
            		userRepository.save(reserve.get());
            	}
            	
            	
            	UserDetailEntity entity = modelMapper.map(userDetailDTO, UserDetailEntity.class);
                entity = userdetailRepository.save(entity);
                updateFlg = true;

            } 
          }
        catch(Exception e) {
            	e.printStackTrace();
        }
        return updateFlg;

    }
	
	public UserDataDto findByUserId(Integer userId) {
		Optional<UserEntity> reEntity = userRepository.findById(userId) ;
		List<UserDataDto> result = new ArrayList<>();
		if (reEntity != null) {

			UserDetailEntity userdetails = userdetailRepository.findByUserId(userId);

			Optional<ProvincesEntity> proDtails = provinRepository.findById(userdetails.getProvinceId());
			Optional<AmphuresEntity> proDetails = ampRepository.findById(userdetails.getAcode());
			DistrictsEntity pDetails = adeRepository.findDistrict(String.valueOf(userdetails.getTcode()));
				UserDataDto obj = new UserDataDto();
				obj.setUserId(userdetails.getUserId());
				obj.setFristName(userdetails.getFristName());
				obj.setLastName(userdetails.getLastName());
				obj.setUsername(reEntity.get().getUsername());
				obj.setPassword(reEntity.get().getPassword());
				obj.setAddress(userdetails.getUserAddress());;
				obj.setUserdeId(userdetails.getUserdeId());
				obj.setSvcId(userdetails.getSvcId());
				obj.setSvcName(userdetails.getSvcName());
				obj.setSvcDocument(userdetails.getSvcDocument());
				obj.setAddress(userdetails.getUserAddress());
				obj.setUserImege(userdetails.getUserImege());
				obj.setPhone(userdetails.getUserPhone());
				obj.setEmail(userdetails.getUserEmail());
				obj.setAmphurNameTh(proDetails.get().getAmphurNameTh());
				obj.setAcode(userdetails.getAcode());
				obj.setTcode(userdetails.getTcode());
				obj.setUserZibId(userdetails.getUserZibId());
				obj.setProvinceId(proDtails.get().getProvinceId());
				obj.setProvinceNameTh(proDtails.get().getProvinceNameTh());
				obj.setAmphurNameTh(proDetails.get().getAmphurNameTh());
				obj.setDistrictNameTh(pDetails.getDistrictNameTh());
				obj.setRecordStatus(userdetails.getRecordStatus());
				result.add(obj);
			}

		

		return result.get(0);
	}
}
	


