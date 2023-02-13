package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.RoleDto;
import com.it.entity.RoleEntity;
import com.it.repository.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;

	public List<RoleDto> findRoleAll() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		return modelMapper.map(roleEntities, new TypeToken<List<RoleDto>>() {}.getType());
	}
	
	
	public RoleDto findByRoleId(Integer roleId) {
		Optional<RoleEntity> roleOtn = roleRepository.findById(roleId);
		if (roleOtn.isPresent()) {
			return modelMapper.map(roleOtn.get(), new TypeToken<RoleDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveRoles(RoleDto roleDto) {
		boolean saveFlg = false;
		try {
			RoleEntity entity = modelMapper.map(roleDto, RoleEntity.class);
			roleRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateRoleId(Integer roleId, RoleDto roleDto) {
        boolean updateFlg  = false;
        try {
            Optional<RoleEntity> roleOtn = roleRepository.findById(roleId);
            if ( roleOtn.isPresent()) {
                RoleEntity entity = modelMapper.map(roleDto, RoleEntity.class);
                roleRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteRoleById(Integer roleId) {
		boolean deleteFlg = false;
		try {
			roleRepository.deleteById(roleId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	


}
