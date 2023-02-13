package com.it.dto;



import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class UserDetailDto {
	
	private Integer userdeId;
	private Integer userId;
	private Integer roleId;
	private Integer svcId;
	private String username;
	private String password;
	private String fristName;
	private String lastName;
	private String svcName;
	private String address;
	private String zibId;
	private Integer tcode;
	private Integer acode;
	private Integer provinceId;
	private String phone;
	private String email;
	private String userImege;
	private MultipartFile fileSlip;
	private String svcDocument;
	private MultipartFile fileX;
	private String recordStatus;
	private String imageBlobUrl;

	
	 
	
	
	
	
	
	
	
	
	
	
}
