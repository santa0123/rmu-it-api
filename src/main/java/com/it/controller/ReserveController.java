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


import com.it.dto.ReserveDto;
import com.it.service.ReserveService;


@RestController
@RequestMapping("/v1/reserves")
public class ReserveController {
	
	@Autowired 
	private ReserveService reserveService;
	
	@GetMapping
	public ResponseEntity<Object> getReserves() {
		return ResponseEntity.ok(reserveService.findReserveAll());		
	}
	
	@GetMapping("/{reserve_id}")
	public ResponseEntity<Object> getRserveId(@PathVariable(name = "reserve_id") Integer reserveId) {
		return ResponseEntity.ok(reserveService.findByreserveId(reserveId));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveReserve(@RequestBody ReserveDto reserveDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(reserveService.saveReserve(reserveDto));
	}
	
	@PutMapping("/{reserve_id}")
	public ResponseEntity<Object> updateReserve(@PathVariable(name = "reserve_id") Integer reserveId, @RequestBody ReserveDto reserveDto) {
		return ResponseEntity.ok(reserveService.updatereserve(reserveId, reserveDto));		
	}
	
	@DeleteMapping("/{reserve_id}")
	public ResponseEntity<Object> deleteByReserveId(@PathVariable(name = "reserve_id") Integer reserveId) {
		return ResponseEntity.ok(reserveService.deletereserveById(reserveId));		
	}

}

