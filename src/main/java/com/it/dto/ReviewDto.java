package com.it.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ReviewDto {
	private Integer reId;
	private Integer svcId;
	private Integer userId;
	private BigDecimal rvRank;
	private String rvComment;
	private BigDecimal sumRank;
	private String recordStatus;
	private Integer userdeId;
	private String fristName;
	private String lastName;
	private String userImege;
	private String rvUrl;

}
