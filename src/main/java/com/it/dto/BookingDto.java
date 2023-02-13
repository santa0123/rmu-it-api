package com.it.dto;



import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.it.utils.TimestampSerializer;

import lombok.Data;

@Data
public class BookingDto {
	
	private Integer resdeId;
	private Integer reserveId;
	private Integer userId;
	private Integer roleId;
	private Integer svcId;
	private String fristName;
	private String lastName;
	private String svcName;
	private Integer workId;
	private String wkName;
	@JsonSerialize(using = TimestampSerializer.class)
	private Date bookStartDate;
	@JsonSerialize(using = TimestampSerializer.class)
	private Date bookEndDate;
	private String recordStatus;
	private String wkImage;
	private String wkUrl;


}
