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

import com.it.dto.UserDTO;
import com.it.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Object> getUsers() {
		return ResponseEntity.ok(userService.findUserAll());		
	}
	
	@GetMapping("/username")
	public ResponseEntity<Object> getByserach(@RequestParam String username) {
		return ResponseEntity.ok(userService.getBySechUsername(username));		
	}
	@GetMapping("/recordStatus")
	public ResponseEntity<Object> getAllByrecordStatus(@RequestParam String recordStatus) {
		return ResponseEntity.ok(userService.findByAllrecordStatus(recordStatus));		
	}
	
	
	@GetMapping("/{user_id}")
	public ResponseEntity<Object> getUserId(@PathVariable(name = "user_id") Integer userId) {
		return ResponseEntity.ok(userService.findUserdeByUserId(userId));		
	}
	
	@GetMapping("/{username}/{password}")
    public ResponseEntity<Object> getByUserNamePassword(@PathVariable(name = "username") String  username, @PathVariable(name = "password") String  password ) {
        return ResponseEntity.ok(userService.getByUserNamePassword(username,password));
    }
	
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody UserDTO userDTO) {
		//roleRepository.save(null);
		return ResponseEntity.ok(userService.saveUser(userDTO));
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<Object> updateUser(@PathVariable(name = "user_id") Integer userId, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.updateUser(userId, userDTO));		
	}
	
	@DeleteMapping("/{user_id}")
	public ResponseEntity<Object> deleteRoleByUserId(@PathVariable(name = "user_id") Integer userId) {
		return ResponseEntity.ok(userService.deleteUserById(userId));		
	}
	
	@GetMapping("/roleId")
	public ResponseEntity<Object> getByroleId(@RequestParam(name = "roleId") Integer roleId,@RequestParam(name = "recordStatus") String recordStatus) {
		return ResponseEntity.ok(userService.getByRoleId(roleId, recordStatus));		
	}
	

}
