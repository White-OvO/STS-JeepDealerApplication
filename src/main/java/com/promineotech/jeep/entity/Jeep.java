package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// 	step 9 : Create a new package in src/main/java named 
//	com.promineotech.jeep.entity.  In that package, create an enum named JeepModel. Add all the jeep models from the model_id column in the models table in the database. 


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Jeep {
	private Long modelPk;
	private JeepModel modelId;
	private String trimLevel;
	private int numDoors;
	private int wheelSize;
	private BigDecimal basePrice;
}
