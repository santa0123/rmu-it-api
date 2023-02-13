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
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.BookingDto;
import com.it.dto.ReserveDetailDto;
import com.it.service.ReservDetailService;

@RestController
@RequestMapping("/v1/reservedetails")
public class ReserveDetailController {
	
	@Autowired 
	private ReservDetailService reservedeService;
	
	@GetMapping
	public ResponseEntity<Object> getReservdes() {
		return ResponseEntity.ok(reservedeService.findReDeAll());		
	}
	
	@GetMapping("/{resde_id}")
	public ResponseEntity<Object> getReservdeId(@PathVariable(name = "resde_id") Integer resdeId) {
		return ResponseEntity.ok(reservedeService.findReDeByReDeId(resdeId));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveReservde(@RequestBody ReserveDetailDto reservedetailDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(reservedeService.saveReservede(reservedetailDto));
	}
	
	@PutMapping("/{reserveId}")
	public ResponseEntity<Object> updateReservde(@PathVariable(name = "reserveId") Integer reserveId, @RequestBody ReserveDetailDto reservedetailDto) {
		return ResponseEntity.ok(reservedeService.updateReservedeId(reserveId, reservedetailDto));		
	}
	
	@DeleteMapping("/{resde_id}")
	public ResponseEntity<Object> deleteRoleByReservdeId(@PathVariable(name = "resde_id") Integer resdeId) {
		return ResponseEntity.ok(reservedeService.deletReservedeById(resdeId));		
	}

}
