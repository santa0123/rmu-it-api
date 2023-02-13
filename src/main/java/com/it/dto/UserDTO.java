package com.it.dto;

import lombok.Data;

@Data
public class UserDTO {
	
	private Integer userId;
	private Integer roleId;
	private String username;
	private String password;
	private String recordStatus;
	
	
}
