package com.it.dto;

import lombok.Data;

@Data
public class AuthenDTO {

	private Integer userId;
	private String username;
	private String roleId;
	private String roleName;
	private String recordStatus;
	
}
