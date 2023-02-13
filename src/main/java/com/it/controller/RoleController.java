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

import com.it.dto.RoleDto;
import com.it.service.RoleService;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {
	
	@Autowired 
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<Object> getAllRoles() {
		return ResponseEntity.ok(roleService.findRoleAll());		
	}
	
	@GetMapping("/{role_id}")
	public ResponseEntity<Object> getRoleByRoleId(@PathVariable(name = "role_id") Integer roleId) {
		return ResponseEntity.ok(roleService.findByRoleId(roleId));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveRole(@RequestBody RoleDto roleDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(roleService.saveRoles(roleDto));
	}
	
	@PutMapping("/{role_id}")
	public ResponseEntity<Object> updateRole(@PathVariable(name = "role_id") Integer roleId, @RequestBody RoleDto roleDto) {
		return ResponseEntity.ok(roleService.updateRoleId(roleId, roleDto));		
	}
	
	@DeleteMapping("/{role_id}")
	public ResponseEntity<Object> deleteRoleByRoleId(@PathVariable(name = "role_id") Integer roleId) {
		return ResponseEntity.ok(roleService.deleteRoleById(roleId));		
	}

}
