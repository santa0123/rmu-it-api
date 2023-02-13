package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ReserveDto;

import com.it.entity.ReserveEntity;
import com.it.repository.ReserveRepository;

@Service
public class ReserveService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReserveRepository reseRepository;

	public List<ReserveDto> findReserveAll() {
		List<ReserveEntity> reserveEntities = reseRepository.findAll();
		return modelMapper.map(reserveEntities, new TypeToken<List<ReserveDto>>() {}.getType());
	}
	
	
	public ReserveDto findByreserveId(Integer reserveId) {
		Optional<ReserveEntity> reservOtn = reseRepository.findById(reserveId);
		if (reservOtn.isPresent()) {
			return modelMapper.map(reservOtn.get(), new TypeToken<ReserveDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveReserve(ReserveDto reserveDto) {
		boolean saveFlg = false;
		try {
			ReserveEntity entity = modelMapper.map(reserveDto, ReserveEntity.class);
			reseRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}
	
	public boolean updatereserve(Integer reserveId, ReserveDto reserveDto) {
        boolean updateFlg  = false;
        try {
            Optional<ReserveEntity> reservOtn = reseRepository.findById(reserveId);
            if (reservOtn.isPresent()) {
                ReserveEntity entity = modelMapper.map(reserveDto, ReserveEntity.class);
                reseRepository.save(entity);
                updateFlg = true;

            }
        } catch(Exception e) {

        }
        return updateFlg;

    }

	
	public boolean deletereserveById(Integer reserveId) {
		boolean deleteFlg = false;
		try {
			reseRepository.deleteById(reserveId);
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}
	
	

}



