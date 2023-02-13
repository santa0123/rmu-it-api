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
@Table(name="area_amphures")
public class AmphuresEntity implements Serializable{
	private static final long serialVersionUID = -4621699675966504633L;
	
	@Id
	@Column(name = "amphur_id")
    private Integer amphurId;
	
	@Column(name = "amphur_name_th")
    private String amphurNameTh;
	
	@Column(name = "amphur_name_en")
    private String amphurNameEn;
	
	@Column(name = "ref_province_id")
    private Integer refProvinceId;
	
	

}
