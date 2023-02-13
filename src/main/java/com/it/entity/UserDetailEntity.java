package com.it.entity;

import java.sql.Timestamp;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_user_detail")
public class UserDetailEntity implements Serializable {
	
	
	private static final long serialVersionUID = -8976925434228465235L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userde_id")
	private Integer userdeId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="svc_id")
	private Integer svcId;
	
	@Column(name="fristName")
	private String fristName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="svc_name")
	private String svcName;
	
	@Column(name="svc_document")
	private String svcDocument;
	
	@Column(name="user_address")
	private String userAddress;
	
	@Column(name="user_zib_id")
	private String userZibId;
	
	@Column(name="tcode")
	private Integer tcode;
	
	@Column(name="acode")
	private Integer acode;
	
	@Column(name="province_id")
	private Integer provinceId;
	
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_imege")
	private String userImege;
	
	@Column(name="record_status")
    private String recordStatus;
	
	@Column(name="creat_by")
    private String creatBy;
	
	@CreationTimestamp
	@Column(name="creat_date" , nullable = false , updatable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
    private Timestamp creatDate;
	
	@Column(name="update_by")
    private String updateBy;
	
	@UpdateTimestamp
	@Column(name="update_date", nullable = false , updatable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
    private Timestamp updateDate;
	
	


	{
		
	}



	

}
