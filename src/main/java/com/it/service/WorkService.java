package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.it.constants.Constants;
import com.it.dto.BookingDto;
import com.it.dto.ReviewDto;
import com.it.dto.UserDataDto;
import com.it.dto.UserDetailDto;
import com.it.dto.WorkDto;
import com.it.entity.ReviewEntity;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.entity.WorkEntity;
import com.it.repository.UserDetailRepository;
import com.it.repository.WorkRepository;
import com.it.utils.Utils;

@Service
public class WorkService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WorkRepository workRepository;
	
	@Autowired
	private UserDetailRepository userdetailRepository;

	public List<WorkDto> findWorkAll() {
		List<WorkEntity> workEntities = workRepository.findAll();
		return modelMapper.map(workEntities, new TypeToken<List<WorkDto>>() {}.getType());
	}
	
	
	public WorkDto findWorkByWorkId(Integer workId) {
		Optional<WorkEntity> workOtn = workRepository.findById(workId);
		if (workOtn.isPresent()) {
			return modelMapper.map(workOtn.get(), new TypeToken<WorkDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveWork(WorkDto workDto) {
		boolean saveFlg = false;
        try {
        	
        	if(null != workDto) {
            	WorkEntity entity = modelMapper.map(workDto, WorkEntity.class);
            	
            	String prefixFile = Utils.genaratePrefixFile();
            	entity.setWkImage(Utils.concatStr(prefixFile, workDto.getWkImage()));
    			Utils.moveFile(workDto.getFileSlip(), Utils.concatStr(prefixFile, workDto.getWkImage()),
    					Constants.PATH_TYPE_INPUT);
   
    			entity =  workRepository.save(entity);
     
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateWorkId(Integer workId, WorkDto workDto) {
        boolean updateFlg  = false;
        try {
            Optional<WorkEntity> workOtn = workRepository.findById(workId);
            if ( workOtn.isPresent()) {
                WorkEntity entity = modelMapper.map(workDto, WorkEntity.class);
                workRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deleteWorkById(Integer workId) {
		boolean deleteFlg = false;
		try {
			workRepository.deleteById(workId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	public List<WorkDto> getBysvcId(Integer svcId) {
	List<WorkEntity> userEntity = workRepository.getBySvcId(svcId);
	 if(userEntity != null) {
           return modelMapper.map(userEntity, new TypeToken<List<WorkDto>>() {}.getType());
       }
       return null;
   }
	
	public WorkDto findByWork(Integer workId) {
		Optional<WorkEntity> workOtn = workRepository.findById(workId);
		List<WorkDto> result = new ArrayList<>();
		if (workOtn != null) {

			
				UserDetailEntity svcDetails = userdetailRepository.findBySvcId(workOtn.get().getSvcId());

				WorkDto obj = new WorkDto();
				obj.setWorkId(workOtn.get().getWorkId());
				obj.setWkName(workOtn.get().getWkName());
				obj.setWkImage(workOtn.get().getWkImage());
				obj.setSvcId(workOtn.get().getSvcId());
				obj.setSvcName(svcDetails.getSvcName());
				result.add(obj);

			}

		

		return result.get(0);
	}
	
	

	

}