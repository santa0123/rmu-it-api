package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.UserDetailDto;
import com.it.service.UserDataService;
import com.it.service.UserDetailService;

@RestController
@RequestMapping("/v1/userdatas")
public class UserDataController {
	
	@Autowired 
	private UserDataService userdetaService;
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<Object> updateUserDetail(@PathVariable(name = "userId") Integer userId, @RequestBody  UserDetailDto userdetailDto) {
		return ResponseEntity.ok(userdetaService.updateUserDetailByUserId(userId, userdetailDto));		
	}
	
	@GetMapping("/userId")
	public ResponseEntity<Object> getByroleId(@RequestParam(name = "userId") Integer userId) {
		return ResponseEntity.ok(userdetaService.findByUserId(userId));		
	}


}
