package com.it.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name="area_provinces")
public class ProvincesEntity implements Serializable {
	
	private static final long serialVersionUID = -4621699675966504633L;
	
	@Id
	@Column(name = "province_id")
    private Integer provinceId;
	
	@Column(name = "province_name_th")
    private String provinceNameTh;
	
	@Column(name = "province_name_en")
    private String provinceNameEn;
	

}
