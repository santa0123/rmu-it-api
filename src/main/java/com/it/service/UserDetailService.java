package com.it.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.constants.Constants;
import com.it.dto.BookingDto;
import com.it.dto.UserDTO;
import com.it.dto.UserDataDto;
import com.it.dto.UserDetailDto;
import com.it.entity.ProvincesEntity;
import com.it.entity.ReserveDetailEntity;
import com.it.entity.ReserveEntity;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.entity.WorkEntity;
import com.it.repository.ProvincesRepository;
import com.it.repository.UserDetailRepository;
import com.it.repository.UserRepository;
import com.it.utils.Utils;

@Service
public class UserDetailService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserDetailRepository userdetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProvincesRepository provinRepository;

	public List<UserDetailDto> findUserAll() {
		List<UserDetailEntity> userEntities = userdetailRepository.findAll();
		return modelMapper.map(userEntities, new TypeToken<List<UserDetailDto>>() {}.getType());
	}

    public UserDetailDto findUserDetailByuserDetailId(Integer userId) {
        UserDetailEntity userEntity =  userdetailRepository.findByUserId(userId);
        if(userEntity != null) {
            return modelMapper.map(userEntity, new TypeToken<UserDetailDto>() {}.getType());
        }
        return null;
    }
    
    public UserDetailDto findUserDetailBySvcId(Integer svcId) {
        UserDetailEntity userEntity =  userdetailRepository.findBySvcId(svcId);
        if(userEntity != null) {
            return modelMapper.map(userEntity, new TypeToken<UserDetailDto>() {}.getType());
        }
        return null;
    }
    public List<UserDetailDto> findByAllrecordStatus(String recordStatus){
		List<UserDetailEntity> userEntity = userdetailRepository.getByAllrecord(recordStatus);
		return modelMapper.map(userEntity, new TypeToken<List<UserDetailDto>>() {}.getType());
	}
	
	public boolean saveUserDetail(UserDetailDto userDetailDto) {
		boolean saveFlg = false;
		try { 
			UserEntity pol = userRepository.getByUserName(String.valueOf(userDetailDto.getUsername()));
			
			if(null == pol) {
				UserDetailEntity userDetailentity = modelMapper.map(userDetailDto, UserDetailEntity.class);
				UserEntity userEntity = modelMapper.map(userDetailDto, UserEntity.class);
				
            	String prefixFile = Utils.genaratePrefixFile();
            	userDetailentity.setUserImege(Utils.concatStr(prefixFile, userDetailDto.getUserImege()));
    			Utils.moveFile(userDetailDto.getFileSlip(), Utils.concatStr(prefixFile, userDetailDto.getUserImege()),
    					Constants.PATH_TYPE_INPUT);
    			
    			if(null != userDetailDto.getSvcDocument()) {
        			userDetailentity.setSvcDocument(Utils.concatStr(prefixFile, userDetailDto.getSvcDocument()));
        			Utils.moveFile(userDetailDto.getFileX(), Utils.concatStr(prefixFile, userDetailDto.getSvcDocument()),
        					Constants.PATH_TYPE_INPUT);
    			}
    			
    			if(userEntity.getRoleId() == 3) {
            		userDetailentity.setSvcId(genarateSvcIdPatten());
            	}
    			
    			
                userEntity = userRepository.save(userEntity);
                userDetailentity.setUserId(userEntity.getUserId());
                userdetailRepository.save(userDetailentity);
                saveFlg = true; 
    		}
			
			

            
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateUserDetail(Integer userdeId, UserDetailDto userDetailDTO) {
        boolean updateFlg  = false;
        try {
            Optional<UserDetailEntity> userDetailOnt = userdetailRepository.findById(userdeId);
            if (userDetailOnt.isPresent()) {
                UserDetailEntity entity = modelMapper.map(userDetailDTO, UserDetailEntity.class);
                userdetailRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }
	
	


	
	public boolean deleteUserdeById(Integer userdeId) {
		boolean deleteFlg = false;
		try {
			userdetailRepository.deleteById(userdeId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	public List<UserDetailDto> getByserchSvc(String svcName) {
        List<UserDetailEntity> userEntity =  userdetailRepository.findBySerach(svcName);
        if(userEntity != null) {
            return modelMapper.map(userEntity, new TypeToken<List<UserDetailDto>>() {}.getType());
        }
        return null;
    }
	public List<UserDetailDto> getByserchfnamelame(String fristName) {
        List<UserDetailEntity> userEntity =  userdetailRepository.findBySerachFnameLname(fristName);
        if(userEntity != null) {
            return modelMapper.map(userEntity, new TypeToken<List<UserDetailDto>>() {}.getType());
        }
        return null;
    }
	
	public List<UserDataDto> getByserchProvicne(String provinceNameTh) {
		List<UserDetailEntity> userEntity =  userdetailRepository.findBySerachProvine(provinceNameTh);
		List<UserDataDto> result = new ArrayList<>();
		if(null != userEntity && !userEntity.isEmpty()) {
			List<UserDetailEntity> userdetailEntity = userdetailRepository.getByAllrecord("1");

			for (UserDetailEntity data:userEntity) {
				List<UserDetailEntity> userdetails = userdetailEntity.stream().filter(a-> a.getUserId().equals(data.getUserId())).collect(Collectors.toList());
				Optional<ProvincesEntity> proDtails = provinRepository.findById(userdetails.get(0).getProvinceId());
				if(null != userdetails && !userdetails.isEmpty()) {
					UserDataDto obj = new UserDataDto();
					obj.setUserId(userdetails.get(0).getUserId());
					obj.setFristName(userdetails.get(0).getFristName());
					obj.setLastName(userdetails.get(0).getLastName());
					obj.setUserdeId(userdetails.get(0).getUserdeId());
					obj.setSvcId(userdetails.get(0).getSvcId());
					obj.setSvcName(userdetails.get(0).getSvcName());
					obj.setAddress(userdetails.get(0).getUserAddress());
					obj.setUserImege(userdetails.get(0).getUserImege());
					obj.setPhone(userdetails.get(0).getUserPhone());
					obj.setEmail(userdetails.get(0).getUserEmail());
					obj.setProvinceNameTh(proDtails.get().getProvinceNameTh());;

					result.add(obj);
				}
			}
		}
		return result;
	}
		public Integer genarateSvcIdPatten() {
		
		int i = (int) (new Date().getTime()/1000);
		
		return Integer.valueOf(i);
	}
	
	

}
