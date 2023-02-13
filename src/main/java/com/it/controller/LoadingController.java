package com.it.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.service.LoadingService;

@RestController
@RequestMapping("/v1/loading")
public class LoadingController {

	@Autowired
	private LoadingService loadingService;
	
	
	@GetMapping("/{fileName}")
	public ResponseEntity<byte[]> getImage(@PathVariable(name = "fileName") String fileName) throws IOException{
		
		return ResponseEntity.ok(loadingService.getImage(fileName));	
	}
	
}
