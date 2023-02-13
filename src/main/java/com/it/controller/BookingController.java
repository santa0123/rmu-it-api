package com.it.controller;

import java.sql.Timestamp;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.BookingDto;
import com.it.dto.ReserveDetailDto;
import com.it.service.BookingService;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {
	
	@Autowired 
	private BookingService bookingService;
	
	@GetMapping("/recordStatus")
	public ResponseEntity<Object> getByreservId(@RequestParam(name = "recordStatus") String recordStatus) {
		return ResponseEntity.ok(bookingService.findByreserveRecoed(recordStatus));		
	}
	
	@GetMapping("/reserveId")
	public ResponseEntity<Object> getReserveId(@RequestParam(name = "reserveId") Integer reserveId) {
		return ResponseEntity.ok(bookingService.findByreserveId(reserveId));		
	}
	
	@GetMapping("/svcId")
	public ResponseEntity<Object> getBySvcId(@RequestParam(name = "svcId") Integer svcId, @RequestParam(name = "recordStatus") String recordStatus) {
		return ResponseEntity.ok(bookingService.findBySvcId(svcId,recordStatus));		
	}
	
	@GetMapping("/userId")
	public ResponseEntity<Object> getUserId(@RequestParam(name = "userId") Integer userId,@RequestParam(name = "recordStatus") String recordStatus) {
		return ResponseEntity.ok(bookingService.findByUserId(userId, recordStatus));	}	
	
	@GetMapping("/bookStartDate")
	public ResponseEntity<Object> getByserach(@RequestParam String bookStartDate) throws ParseException {
		return ResponseEntity.ok(bookingService.getByserchTime(bookStartDate));		
	}
	

}
