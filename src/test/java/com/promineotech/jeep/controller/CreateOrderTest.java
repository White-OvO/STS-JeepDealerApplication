package com.promineotech.jeep.controller;









import java.net.http.HttpHeaders;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

// week 16 step 1: Create a new integration test class to test a Jeep order named 
//CreateOrderTest.java. Create this class in src/test/java in the 
//com.promineotech.jeep.controller package. Add the Spring Boot Test annotations:
//@SpringBootTest, @ActiveProfiles, and @Sql. They should have the same parameters 
//as the test created in weeks 1 and 2.Create a test method (annotated with @Test)
//named testCreateOrderReturnsSuccess201.In the test class, create a method named 
//createOrderBody. This method returns a type of String. In this method, return a 
//JSON object with the IDs that you picked in Step 1a and 1b

import org.springframework.test.context.jdbc.Sql;
@ActiveProfiles
@Sql(	
		scripts = {
				"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
	    		"classpath:flywnfig(encoding = "utf-8"))	
@SpringBootTest	
public class CreateOrderTest {
@LocalServerPort									//week 16 step 3 : In the test class, add an instance variable named
                                                //serverPort to hold the port that Tomcat is listening on in the test. 
                                                //Annotate the variable with @LocalServerPort.


private  TestRestTemplate restTemplate;

												//WEEK 16: Step 4  Add another instance variable for an injected 
//String uri = String.format("http://localhost:%d/orders", serverPort);												//			TestRestTemplate named restTemplate.
//	HttpHeaders heards = new HttpHeaders();											// week 16 :step 5 In the test method, assign a value to a local variable named uri 			


@Test
void testCreateOrderReturnsSuccess201()
			{                              // week 16 step 2: In the test method, assign the return value of the 
											//createOrderBody() method to a variable named body.

// given : an order as JSON
String body = CreateOrderBody();
											//week 16 step 3 : In the test class, add an instance variable named
											//serverPort to hold the port that Tomcat is listening on in the test. 
											//Annotate the variable with @LocalServerPort.
						
//when the order is sent

//then : 201 status is returned


//and the return oder is returned
	
			}                       // we are making the jeep  boarder
	
//@formatter:off
String CreateOrderBody () { 
		return "{\n"      
	+ " \"customer\":\"Christopher_Gonzalez\",\n"
	+ " \"model\":\"GLADIATOR\",\n"
	+ " \"trim\":\"Mojave\",\n"
	+ " \"doors\":4,\n"
	+ " \"color\":\"EXT_SARGE_GREEN\",\n"
	+ " \"engine\":\"3_6_HYBRID\",\n"	
	+ " \"tire\":\"255_TOYO\",\n"
	+ " \"options\":[\n"
	+ " 	  \"DOOR_QUAD_ALUM_FRONT\",\n"
	+ "	      \"EXT_WARN_WINCH\",\n"
	+ "	      \"EXT_WARN_BUMPER_FRONT\",\n"
	+ "	      \"EXT_WARN_BUMPER_REAR\",\n"
	+ "	      \"EXT_ARB_COMPRESSOR\"\n"
	+ "   ]\n"
	+ " }\n"
	+ "";
	//@formatter:on
	
	}



}
