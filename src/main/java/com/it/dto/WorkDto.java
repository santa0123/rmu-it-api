package com.it.dto;


import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class WorkDto {
	private Integer workId;
	private Integer svcId;
	private String svcName;
	private String wkName;
	private String wkDesc;
	private String wkImage;
	private String wkUrl;
	private MultipartFile fileSlip;
	
	
	
	

}
