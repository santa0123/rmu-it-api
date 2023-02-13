package com.it.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ReserveDetailDto;
import com.it.entity.ReserveDetailEntity;
import com.it.entity.ReserveEntity;
import com.it.repository.ReserveDetailRepository;
import com.it.repository.ReserveRepository;
import com.it.utils.DateUtils;


@Service
public class ReservDetailService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReserveDetailRepository resevedeRepository;
	
	@Autowired
	private ReserveRepository reseRepository;

	public List<ReserveDetailDto> findReDeAll() {
		List<ReserveDetailEntity> reservEntities =  resevedeRepository.findAll();
		return modelMapper.map(reservEntities, new TypeToken<List<ReserveDetailDto>>() {}.getType());
	}
	
	
	public ReserveDetailDto findReDeByReDeId(Integer resdeId) {
		Optional<ReserveDetailEntity> resdeOtn = resevedeRepository.findById(resdeId);
		if (resdeOtn.isPresent()) {
			return modelMapper.map(resdeOtn.get(), new TypeToken<ReserveDetailDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveReservede(ReserveDetailDto reservedetailDto) {
		boolean saveFlg = false;
		try {
			
			ReserveDetailEntity resEntity = resevedeRepository.findByBookStartDate(Timestamp.valueOf(reservedetailDto.getBookStartDate()));
			
			if(null == resEntity) {
				ReserveEntity entity = modelMapper.map(reservedetailDto, ReserveEntity.class);
				entity = reseRepository.save(entity);
				ReserveDetailEntity entitydetails = modelMapper.map(reservedetailDto, ReserveDetailEntity.class);
				entitydetails.setReserveId(entity.getReserveId());
				resevedeRepository.save(entitydetails);
				saveFlg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updateReservedeId(Integer reserveId, ReserveDetailDto reservedetailDto) {
        boolean updateFlg  = false;
        try {
        	List<ReserveDetailEntity> resdeOtn = resevedeRepository.findByReserveId(reserveId);
            if (!resdeOtn.isEmpty()) {
            	
            	Optional<ReserveEntity> reserve = reseRepository.findById(reserveId);
            	
            	if(reserve.isPresent()) {
            		reserve.get().setRecordStatus(reservedetailDto.getRecordStatus());
            		reseRepository.save(reserve.get());
            	}
            	
            	
                ReserveDetailEntity entity = modelMapper.map(reservedetailDto, ReserveDetailEntity.class);
                entity = resevedeRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return updateFlg;

    }

	
	public boolean deletReservedeById(Integer resdeId) {
		boolean deleteFlg = false;
		try {
			resevedeRepository.deleteById(resdeId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}


