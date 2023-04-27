package com.promineotech.jeep.controller;




import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Order;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(	
		scripts = {
				"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
				"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
	    		config = @SqlConfig(encoding = "utf-8"))	
	
public class CreateOrderTest {
									//week 16 step 3 : In the test class, add an instance variable named
                                                //Annotate the variable with @LocalServerPort.
@Autowired

private  TestRestTemplate restTemplate;
@LocalServerPort

private int serverPort;                                            //serverPort to hold the port that Tomcat is listening on in the test. 
											//WEEK 16: Step 4  Add another instance variable for an injected 
//String uri = String.format("http://localhost:%d/orders", serverPort);												//			TestRestTemplate named restTemplate.
//	HttpHeaders heards = new HttpHeaders();											// week 16 :step 5 In the test method, assign a value to a local variable named uri 			


@Test
void testCreateOrderReturnsSuccess201()
			{                              // week 16 step 2: In the test method, assign the return value of the 
											//createOrderBody() method to a variable named body.

// given : an order as JSON
String body = createOrderBody();
											//week 16 step 3 : In the test class, add an instance variable named
															//serverPort to hold the port that Tomcat is listening on in the test. 
																//Annotate the variable with @LocalServerPort.
				String uri = String.format("http://localhost:%d/orders", serverPort);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
					
			HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);						// week 16 : step 7  Create an HttpEntity object and set the request body and headers
					ResponseEntity<Order> response = restTemplate.exchange(uri,HttpMethod.POST, bodyEntity, Order.class);
					
																											//weel 16 step 8:  send the request body and headers to the server. The Order class should have 
																												//been copied earlier from the supplied resources
				
	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	
	assertThat(response.getBody()).isNotNull();
	
	Order order = response.getBody();
	assertThat(order.getCustomer().getCustomerId()).isEqualTo("ROTH_GARTH");
	assertThat(order.getModel().getModelId()).isEqualTo(JeepModel.WRANGLER);
	assertThat(order.getModel().getTrimLevel()).isEqualTo("Rubicon");
	assertThat(order.getModel().getNumDoors()).isEqualTo(4);
	assertThat(order.getColor().getColorId()).isEqualTo("EXT_SNAZZBERRY");
	assertThat(order.getEngine().getEngineId()).isEqualTo("2_0_TURBO");
	assertThat(order.getTire().getTireId()).isEqualTo("255_GOODYEAR");
	assertThat(order.getOptions()).hasSize(6);

																											// week 16 step 9: Add the AssertJ assertions to ensure that the response is correct. Replace the 
																												//expected values to match the JSON in step 2c.
				
				
//when the order is sent					//weel 16 step 4: Add another instance variable for an injected TestRestTemplate named restTemplate.


	
			}                       // we are making the jeep  boarder
	

String createOrderBody () { 

	//@formatter:off
	return "{\n"
		+ "  \"customer\":\"ROTH_GARTH\",\n"
		+ "  \"model\":\"WRANGLER\",\n"
		+ "  \"trim\":\"Rubicon\",\n"
		+ "  \"doors\":4,\n"
		+ "  \"color\":\"EXT_SNAZZBERRY\",\n"
		+ "  \"engine\":\"2_0_TURBO\",\n"
		+ "  \"tire\":\"255_GOODYEAR\",\n"
		+ "  \"options\":[\n"
		+ "    \"DOOR_WARRIOR_MIRROR_MT\",\n"
		+ "    \"EXT_AEV_LIFT\",\n"
		+ "    \"EXT_WARN_WINCH\",\n"
		+ "    \"EXT_WARN_BUMPER_FRONT\",\n"
		+ "    \"EXT_WARN_BUMPER_REAR\",\n"
		+ "    \"EXT_ARB_COMPRESSOR\"\n"
		+ "  ]\n"
		+ "}";
//@formatter:on

	
	}



}
