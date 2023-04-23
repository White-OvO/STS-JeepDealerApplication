package com.promineotech.jeep.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
			//WEEK 16 STEP 15 Add Bean Validation annotations to the OrderRequest class 
		// Add @NotNull to the enum type.

@Data

public class OrderRequest {
	@NotNull 
	@Length(max = 30)
	@Pattern(regexp = "[A-Z_]")
  private String customer;
	@NotNull 
	
  private JeepModel model;
	@NotNull 
	@Length(max = 30)
	@Pattern(regexp = "[A-Z_]")
  
  private String trim;
	@Positive
	@Min(2)
	@Max(4)
  private int doors;
	@NotNull 
	@Length(max = 30)
	@Pattern(regexp = "[A-Z_]")
  
	
  private String color;
	@NotNull 
	@Length(max = 30)
	@Pattern(regexp = "[A-Z_]")
  
	
  private String engine;
          
  private String tire;

  private List<String> options;
}
