package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.service.MasterService;

@RestController
@RequestMapping("/v1/master")
public class MasterController {

	@Autowired
	private MasterService masterService;
	
	@GetMapping("province/{provinceId}")
	public ResponseEntity<Object> findProvincesById(@PathVariable(name = "provinceId") Integer provinceId){
		return ResponseEntity.ok(masterService.findProvincesByProvinceId(provinceId));
	}
	
	@GetMapping("district/{districts}")
	public ResponseEntity<Object> findDistrictsById(@PathVariable(name = "districts") String districts){
		return ResponseEntity.ok(masterService.findDistrictsByDistrictsId(districts));
	}
	
	@GetMapping("amphure/{amphures}")
	public ResponseEntity<Object> findAmphuresById(@PathVariable(name = "amphures") Integer amphures){
		return ResponseEntity.ok(masterService.findAmphuresByAmphuresId(amphures));
	}
	
	@GetMapping("zipcode/{zipcodes}")
	public ResponseEntity<Object> findZipcodesById(@PathVariable(name = "zipcodes") String zipcodes){
		return ResponseEntity.ok(masterService.findZipcodesByZipcodesId(zipcodes));
	}
}
