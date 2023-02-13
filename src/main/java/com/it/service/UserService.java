package com.it.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.dto.UserDTO;
import com.it.dto.UserDataDto;
import com.it.dto.UserDetailDto;
import com.it.entity.ProvincesEntity;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.repository.ProvincesRepository;
import com.it.repository.UserDetailRepository;
import com.it.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailRepository userdetailRepository;
	
	@Autowired
	private ProvincesRepository provinRepository;

	public List<UserDTO> findUserAll() {
		List<UserEntity> userEntities = userRepository.findAll();
		return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
	}
	
	public List<UserDTO> findByAllroleId(Integer roleId){
		List<UserEntity> userEntity = userRepository.getByAllroleId(roleId);
		return modelMapper.map(userEntity, new TypeToken<List<UserDTO>>() {}.getType());
	}
	public List<UserDTO> findByAllrecordStatus(String recordStatus){
		List<UserEntity> userEntity = userRepository.getByAllrecord(recordStatus);
		return modelMapper.map(userEntity, new TypeToken<List<UserDTO>>() {}.getType());
	}
	public UserDTO findUserdeByUserId(Integer userId) {
		Optional<UserEntity> userOtn = userRepository.findById(userId);
		if (userOtn.isPresent()) {
			return modelMapper.map(userOtn.get(), new TypeToken<UserDTO>() {}.getType());
		}
		
		return null;
	}
	
	public UserDTO getByUserNamePassword(String username, String password) {
        UserEntity userOnt = userRepository.getByUserNamePassword(username,password);
        if (userOnt !=null) {
            return modelMapper.map(userOnt, new TypeToken<UserDTO>() {
            }.getType());
        }
        return null;
    }
	
	public boolean saveUser(UserDTO userDTO) {
		boolean saveFlg = false;
		try {
			UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
			userRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateUser(Integer userId, UserDTO userDTO) {
        boolean updateFlg  = false;
        try {
            Optional<UserEntity> userOtn = userRepository.findById(userId);
            if (userOtn.isPresent()) {
                UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
                userRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteUserById(Integer userId) {
		boolean deleteFlg = false;
		try {
			userRepository.deleteByuserId(userId);
			userdetailRepository.deleteByuserId(userId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	public List<UserDataDto> getByRoleId(Integer roleId , String recordStatus){
		List<UserEntity> userEntity = userRepository.getByRoleId(roleId, recordStatus);
		List<UserDataDto> result = new ArrayList<>();
		if(null != userEntity && !userEntity.isEmpty()) {

			for (UserEntity data:userEntity) {
				UserDetailEntity userdetails = userdetailRepository.findByUserId(data.getUserId());
				Optional<ProvincesEntity> proDtails = provinRepository.findById(userdetails.getProvinceId());
					UserDataDto obj = new UserDataDto();
					obj.setUserId(userdetails.getUserId());
					obj.setFristName(userdetails.getFristName());
					obj.setLastName(userdetails.getLastName());
					obj.setUsername(userEntity.get(0).getUsername());
					obj.setPassword(userEntity.get(0).getPassword());
					obj.setUserdeId(userdetails.getUserdeId());
					obj.setSvcId(userdetails.getSvcId());
					obj.setSvcName(userdetails.getSvcName());
					obj.setAddress(userdetails.getUserAddress());
					obj.setUserImege(userdetails.getUserImege());
					obj.setPhone(userdetails.getUserPhone());
					obj.setEmail(userdetails.getUserEmail());
					obj.setProvinceId(proDtails.get().getProvinceId());
					obj.setProvinceNameTh(proDtails.get().getProvinceNameTh());;

					result.add(obj);
				}
			}
		
		return result;
	}
	public List<UserDTO> getBySechUsername(String username) {
        List<UserEntity> userEntity =  userRepository.sechByUserName(username);
        if(userEntity != null) {
            return modelMapper.map(userEntity, new TypeToken<List<UserDTO>>() {}.getType());
        }
        return null;
    }
	

}

