/*package com.promineotech.jeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//	step 1: create a class with a main method named jeep sales

@SpringBootApplication  //starting spring boot 
//	step 2: add a class level annotation: @springBootApplication and the import statment.

public class JeepSales {





// 	step 3: In the main() method, add a call to SpringApplication.run();. Use JeepSales.class as 
//	the first parameter, and the args parameter that was passed into the main() method as the second.


public static void main(String[] args) {
	SpringApplication.run(JeepSales.class, args); //makes a call to springspplicaion, starts main boot
}                                         //Note; JeepSales.class and args are parameters.



}

*/



package com.promineotech.jeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class JeepSales {

  public static void main(String[] args) {
  SpringApplication.run(JeepSales.class, args);

  }

}