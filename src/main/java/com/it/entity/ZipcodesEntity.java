package com.it.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name="area_zipcodes")
public class ZipcodesEntity  implements Serializable {
	
	private static final long serialVersionUID = -4621699675966504633L;
	
	@Id
	@Column(name = "zipcode")
    private String zipcodes;
	
	@Column(name = "district_code")
    private String districtCode;
	
	

}
