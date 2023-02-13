package com.it.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.BookingDto;
import com.it.dto.UserDetailDto;
import com.it.repository.ReserveDetailRepository;
import com.it.repository.ReserveRepository;
import com.it.repository.UserDetailRepository;

import com.it.repository.WorkRepository;
import com.it.entity.ReserveDetailEntity;
import com.it.entity.ReserveEntity;
import com.it.entity.UserDetailEntity;

import com.it.entity.WorkEntity;

@Service
public class BookingService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ReserveDetailRepository resevedeRepository;

	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private UserDetailRepository userdetailRepository;

	@Autowired
	private ReserveRepository reseRepository;

	public List<BookingDto> findByreserveRecoed(String recordStatus) {
		List<ReserveEntity> reEntity = reseRepository.getByrecord(recordStatus);
		List<BookingDto> result = new ArrayList<>();
		if (reEntity != null) {

			for (ReserveEntity data : reEntity) {
				Optional<WorkEntity> workEntity = workRepository.findById(data.getReservDetails().get(0).getWorkId());
				UserDetailEntity userDeEntity = userdetailRepository.findByUserId(data.getUserId());
				UserDetailEntity svcDetails = userdetailRepository.findBySvcId(workEntity.get().getSvcId());


				BookingDto obj = new BookingDto();
				obj.setResdeId(data.getReservDetails().get(0).getResdeId());
				obj.setReserveId(data.getReserveId());
				obj.setWorkId(workEntity.get().getWorkId());
				obj.setWkName(workEntity.get().getWkName());
				obj.setUserId(userDeEntity.getUserId());
				obj.setFristName(userDeEntity.getFristName());
				obj.setLastName(userDeEntity.getLastName());
				obj.setSvcId(workEntity.get().getSvcId());
				obj.setSvcName(svcDetails.getSvcName());
				obj.setBookStartDate(data.getReservDetails().get(0).getBookStartDate());
				obj.setBookEndDate(data.getReservDetails().get(0).getBookEndDate());
				obj.setRecordStatus(data.getReservDetails().get(0).getRecordStatus());
				result.add(obj);

			}

		}

		return result;
	}
	
//	public BookingDto findUserDetailByuserDetailId(Integer reserveId) {
//        ReserveDetailEntity userEntity =  resevedeRepository.findByReserveId(reserveId);
//        if(userEntity != null) {
//            return modelMapper.map(userEntity, new TypeToken<BookingDto>() {}.getType());
//        }
//        return null;
//    }
	public BookingDto findByreserveId(Integer reserveId) {
	ReserveEntity reEntity = reseRepository.findByreserveId(reserveId);
	List<BookingDto> result = new ArrayList<>();
	if (reEntity != null) {

		
			Optional<WorkEntity> workEntity = workRepository.findById(reEntity.getReservDetails().get(0).getWorkId());
			UserDetailEntity userDeEntity = userdetailRepository.findByUserId(reEntity.getUserId());
			UserDetailEntity svcDetails = userdetailRepository.findBySvcId(workEntity.get().getSvcId());


			BookingDto obj = new BookingDto();
			obj.setResdeId(reEntity.getReservDetails().get(0).getResdeId());
			obj.setReserveId(reEntity.getReserveId());
			obj.setWorkId(workEntity.get().getWorkId());
			obj.setWkName(workEntity.get().getWkName());
			obj.setWkImage(workEntity.get().getWkImage());
			obj.setUserId(userDeEntity.getUserId());
			obj.setFristName(userDeEntity.getFristName());
			obj.setLastName(userDeEntity.getLastName());
			obj.setSvcId(workEntity.get().getSvcId());
			obj.setSvcName(svcDetails.getSvcName());
			obj.setBookStartDate(reEntity.getReservDetails().get(0).getBookStartDate());
			obj.setBookEndDate(reEntity.getReservDetails().get(0).getBookEndDate());
			obj.setRecordStatus(reEntity.getReservDetails().get(0).getRecordStatus());
			result.add(obj);

		}

	

	return result.get(0);
}
	
	public List<BookingDto> findBySvcId(Integer svcId, String recordStatus) {
		List<ReserveEntity> reEntity = reseRepository.getBySvcId(svcId,recordStatus);
		List<BookingDto> result = new ArrayList<>();
		if (reEntity != null) {

			for (ReserveEntity data : reEntity) {
				Optional<WorkEntity> workEntity = workRepository.findById(data.getReservDetails().get(0).getWorkId());
				UserDetailEntity userDeEntity = userdetailRepository.findByUserId(data.getUserId());
				UserDetailEntity svcDetails = userdetailRepository.findBySvcId(workEntity.get().getSvcId());


				BookingDto obj = new BookingDto();
				obj.setResdeId(data.getReservDetails().get(0).getResdeId());
				obj.setReserveId(data.getReserveId());
				obj.setWorkId(workEntity.get().getWorkId());
				obj.setWkName(workEntity.get().getWkName());
				obj.setUserId(userDeEntity.getUserId());
				obj.setFristName(userDeEntity.getFristName());
				obj.setLastName(userDeEntity.getLastName());
				obj.setSvcId(workEntity.get().getSvcId());
				obj.setSvcName(svcDetails.getSvcName());
				obj.setBookStartDate(data.getReservDetails().get(0).getBookStartDate());
				obj.setBookEndDate(data.getReservDetails().get(0).getBookEndDate());
				obj.setRecordStatus(data.getReservDetails().get(0).getRecordStatus());
				result.add(obj);

			}

		}

		return result;
	}
	
	public List<BookingDto> findByUserId(Integer userId , String recordStatus) {
		List<ReserveEntity> reEntity = reseRepository.getByUserId(userId, recordStatus);
		List<BookingDto> result = new ArrayList<>();
		if (reEntity != null) {

			for (ReserveEntity data : reEntity) {
				Optional<WorkEntity> workEntity = workRepository.findById(data.getReservDetails().get(0).getWorkId());
				UserDetailEntity userDeEntity = userdetailRepository.findByUserId(data.getUserId());
				UserDetailEntity svcDetails = userdetailRepository.findBySvcId(workEntity.get().getSvcId());


				BookingDto obj = new BookingDto();
				obj.setResdeId(data.getReservDetails().get(0).getResdeId());
				obj.setReserveId(data.getReserveId());
				obj.setWorkId(workEntity.get().getWorkId());
				obj.setWkName(workEntity.get().getWkName());
				obj.setWkImage(workEntity.get().getWkImage());
				obj.setUserId(userDeEntity.getUserId());
				obj.setFristName(userDeEntity.getFristName());
				obj.setLastName(userDeEntity.getLastName());
				obj.setSvcId(workEntity.get().getSvcId());
				obj.setSvcName(svcDetails.getSvcName());
				obj.setBookStartDate(data.getReservDetails().get(0).getBookStartDate());
				obj.setBookEndDate(data.getReservDetails().get(0).getBookEndDate());
				obj.setRecordStatus(data.getReservDetails().get(0).getRecordStatus());
				result.add(obj);

			}

		}

		return result;
	}
//	public List<BookingDto> getByserchTime(Timestamp bookStartDate) {
//        List<ReserveDetailEntity> reservEntity =  resevedeRepository.findBySerach(bookStartDate);
//        if(reservEntity != null) {
//            return modelMapper.map(reservEntity, new TypeToken<List<BookingDto>>() {}.getType());
//        }
//        return null;
//    }
	public List<BookingDto> getByserchTime(String bookStartDate) throws ParseException {
		
		
        String startDate = bookStartDate + " 00:00:00";
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);  
//        Date date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endtDate);  
		
      List<ReserveDetailEntity> reservEntity =  resevedeRepository.findBySerach(date1);
		List<BookingDto> result = new ArrayList<>();
		if (reservEntity != null) {

			for (ReserveDetailEntity data : reservEntity) {
				Optional<ReserveEntity> rereEntity = reseRepository.findById(reservEntity.get(0).getReserveId());
				Optional<WorkEntity> workEntity = workRepository.findById(reservEntity.get(0).getWorkId());
				UserDetailEntity userDeEntity = userdetailRepository.findByUserId(rereEntity.get().getUserId());
				UserDetailEntity svcDetails = userdetailRepository.findBySvcId(workEntity.get().getSvcId());


				BookingDto obj = new BookingDto();
				obj.setResdeId(reservEntity.get(0).getResdeId());
				obj.setReserveId(data.getReserveId());
				obj.setWorkId(workEntity.get().getWorkId());
				obj.setWkName(workEntity.get().getWkName());
				obj.setWkImage(workEntity.get().getWkImage());

				obj.setUserId(userDeEntity.getUserId());
				obj.setFristName(userDeEntity.getFristName());
				obj.setLastName(userDeEntity.getLastName());
				obj.setSvcId(workEntity.get().getSvcId());
				obj.setSvcName(svcDetails.getSvcName());
				obj.setBookStartDate(reservEntity.get(0).getBookStartDate());
				obj.setBookEndDate(reservEntity.get(0).getBookEndDate());
				obj.setRecordStatus(reservEntity.get(0).getRecordStatus());
				result.add(obj);

			}

		}

		return result;
	}
	

}
