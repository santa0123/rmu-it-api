package com.it.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.ReviewDto;
import com.it.dto.UserDTO;
import com.it.dto.UserDataDto;
import com.it.dto.UserDetailDto;
import com.it.entity.ProvincesEntity;
import com.it.entity.ReviewEntity;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.repository.ReviewRepository;
import com.it.repository.UserDetailRepository;

@Service
public class ReviewService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserDetailRepository userdetailRepository;

	public List<ReviewDto> findReviewsAll() {
		List<ReviewEntity> reviewEntities = reviewRepository.findAll();
		return modelMapper.map(reviewEntities, new TypeToken<List<ReviewDto>>() {
		}.getType());
	}

	public List<ReviewDto> findByreviewId(Integer svcId) {
		List<ReviewEntity> userEntity = reviewRepository.getByAllreviewId(svcId);
		if (userEntity != null) {
			return modelMapper.map(userEntity, new TypeToken<List<ReviewDto>>() {
			}.getType());
		}
		return null;
	}

	public boolean saveReviews(ReviewDto reviewDto) {
		boolean saveFlg = false;
		try {
			ReviewEntity entity = modelMapper.map(reviewDto, ReviewEntity.class);
			reviewRepository.save(entity);
			saveFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFlg;
	}

	public boolean updateReview(Integer reId, ReviewDto reviewDto) {
		boolean updateFlg = false;
		try {
			Optional<ReviewEntity> reviewOtn = reviewRepository.findById(reId);
			if (reviewOtn.isPresent()) {
				ReviewEntity entity = modelMapper.map(reviewDto, ReviewEntity.class);
				reviewRepository.save(entity);
				updateFlg = true;

			}
		} catch (Exception e) {

		}
		return updateFlg;

	}

	public boolean deleteReviewById(Integer reId) {
		boolean deleteFlg = false;
		try {
			reviewRepository.deleteById(reId);
			;
			deleteFlg = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFlg;
	}

	public BigDecimal getSumReview(Integer svcId) {
		List<ReviewEntity> userEntity = reviewRepository.getByAllreviewId(svcId);
		if (userEntity != null) {
			
			BigDecimal sumRank = BigDecimal.ZERO;
			
			for(ReviewEntity data : userEntity) {
				sumRank = sumRank.add(data.getRvRank());
			}
			
			return sumRank.divide(new BigDecimal(userEntity.size()),2, RoundingMode.HALF_UP);
		}
		return null;
	}
	
	public List<ReviewDto> findByreview(Integer svcId) {
		List<ReviewEntity> userEntity = reviewRepository.getByAllreviewId(svcId);
		List<ReviewDto> result = new ArrayList<>();
		if(null != userEntity && !userEntity.isEmpty()) {

			for (ReviewEntity data:userEntity) {
				UserDetailEntity userDeEntity = userdetailRepository.findByUserId(data.getUserId());
				ReviewDto obj = new ReviewDto();
					obj.setUserId(userDeEntity.getUserId());
					obj.setFristName(userDeEntity.getFristName());
					obj.setLastName(userDeEntity.getLastName());
					obj.setUserdeId(userDeEntity.getUserdeId());
					obj.setSvcId(data.getSvcId());
					obj.setUserImege(userDeEntity.getUserImege());
					obj.setReId(data.getReId());
					obj.setRvRank(data.getRvRank());
					obj.setRvComment(data.getRvComment());
					

					result.add(obj);
				}
			}
		
		return result;
	}

}
