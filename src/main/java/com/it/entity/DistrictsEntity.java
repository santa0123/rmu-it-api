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
@Table(name="area_districts")
public class DistrictsEntity implements Serializable {
	
	private static final long serialVersionUID = -4621699675966504633L;
	
	@Id
	@Column(name = "district_id")
    private Integer districtId;
	
	@Column(name = "district_code")
    private String districtCode;
	
	@Column(name = "district_name_th")
    private String districtNameTh;
	
	@Column(name = "district_name_en")
    private String districtNameEn;
	
	@Column(name = "ref_amphur_id")
    private Integer refAmphurId;
	
	@Column(name = "ref_province_id")
    private Integer refProvinceId;
	
	
}
