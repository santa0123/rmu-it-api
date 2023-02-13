package com.it.dto;


import lombok.Data;

@Data
public class ReserveDto {
	
	private Integer reserveId;
	private Integer svcId;
	private Integer userId;
	private String recordStatus;

}
