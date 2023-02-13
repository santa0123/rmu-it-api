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
import com.it.service.UserDetailService;

@RestController
@RequestMapping("/v1/userdetails")
public class UserDetailController {
	
	@Autowired 
	private UserDetailService userdetailService;
	
	@GetMapping
	public ResponseEntity<Object> getUserDetailIds() {
		return ResponseEntity.ok(userdetailService.findUserAll());		
	}
	
	@GetMapping("/{userde_id}")
	public ResponseEntity<Object> getRoleByUserDetailId(@PathVariable(name = "userde_id") Integer userId) {
		return ResponseEntity.ok(userdetailService.findUserDetailByuserDetailId(userId));		
	}
	
	@GetMapping("/svc_id")
	public ResponseEntity<Object> getRoleBysvcId(@RequestParam Integer svcId) {
		return ResponseEntity.ok(userdetailService.findUserDetailBySvcId(svcId));		
	}
	
	@GetMapping("/recordStatus")
	public ResponseEntity<Object> getAllByrecordStatus(@RequestParam String recordStatus) {
		return ResponseEntity.ok(userdetailService.findByAllrecordStatus(recordStatus));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveUserDetail(@ModelAttribute UserDetailDto userdetailDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(userdetailService.saveUserDetail(userdetailDto));
	}
	
	@PutMapping("/{userde_id}")
	public ResponseEntity<Object> updateUserDetail(@PathVariable(name = "userde_id") Integer userdeId, @RequestBody  UserDetailDto userdetailDto) {
		return ResponseEntity.ok(userdetailService.updateUserDetail(userdeId, userdetailDto));		
	}
	
	@DeleteMapping("/{userde_id}")
	public ResponseEntity<Object> deleteUserDetailByUserId(@PathVariable(name = "userde_id") Integer userdeId) {
		return ResponseEntity.ok(userdetailService.deleteUserdeById(userdeId));		
	}

	
	@GetMapping("/svcName")
	public ResponseEntity<Object> getByserach(@RequestParam String svcName) {
		return ResponseEntity.ok(userdetailService.getByserchSvc(svcName));		
	}
	
	@GetMapping("/fristName")
	public ResponseEntity<Object> getByserachFnameLname(@RequestParam String fristName) {
		return ResponseEntity.ok(userdetailService.getByserchfnamelame(fristName));		
	}
	@GetMapping("/provinceNameTh")
	public ResponseEntity<Object> getByserachProvine(@RequestParam String provinceNameTh) {
		return ResponseEntity.ok(userdetailService.getByserchProvicne(provinceNameTh));		
	}
}


