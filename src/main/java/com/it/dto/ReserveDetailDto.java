package com.it.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import com.it.utils.TimestampSerializer;

@Data
public class ReserveDetailDto implements Serializable{
	

	private static final long serialVersionUID = -2618445816694819312L;
	
	private Integer resdeId;
	private Integer svcId;
	private Integer userId;
	private Integer reserveId;
	private Integer workId;
	
	@JsonSerialize(using = TimestampSerializer.class)
	private String bookStartDate;
	@JsonSerialize(using = TimestampSerializer.class)
	private String bookEndDate;
	private String recordStatus;

	
	

	
}
