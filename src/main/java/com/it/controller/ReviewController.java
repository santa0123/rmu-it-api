package com.it.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.ReviewDto;
import com.it.service.ReviewService;

@RestController
@RequestMapping("/v1/reviews")
public class ReviewController {
	
	@Autowired 
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<Object> getReviews() {
		return ResponseEntity.ok(reviewService.findReviewsAll());		
	}
	
	@GetMapping("/svcId")
	public ResponseEntity<Object> getReviewId(@RequestParam(name = "svcId") Integer svcId) {
		return ResponseEntity.ok(reviewService.findByreview(svcId));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveReviews(@RequestBody ReviewDto reviewDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(reviewService.saveReviews(reviewDto));
	}
	
	@PutMapping("/{re_id}")
	public ResponseEntity<Object> updateReviews(@PathVariable(name = "re_id") Integer reId, @RequestBody ReviewDto reviewDto) {
		return ResponseEntity.ok(reviewService.updateReview(reId, reviewDto));		
	}
	
	@DeleteMapping("/{re_id}")
	public ResponseEntity<Object> deleteByReviewId(@PathVariable(name = "re_id") Integer reId) {
		return ResponseEntity.ok(reviewService.deleteReviewById(reId));		
	}
	
	@GetMapping("sumreview/{svcId}")
	public ResponseEntity<Object> getSumReview(@PathVariable(name = "svcId") Integer svcId) {
		return ResponseEntity.ok(reviewService.getSumReview(svcId));		
	}

}
