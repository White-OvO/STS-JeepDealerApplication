package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


//create a class hiearchy with test class in the bottom
//STEP 5 :Add the @SpringBootTest, @ActiveProfiles, and @Sql annotations as described in the video. 
//	The class must not be public. It should have package-level access (i.e., not public, private, or protected). 
//@SuppressWarnings("deprecation")



		@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
		@ActiveProfiles("test")
		@Sql(scripts = {
    		"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    		"classpath:flyway/migrations/V1.1__Jeep_Data.sql"}, 
    		config = @SqlConfig(encoding = "uft-8"))
//	@SqlConfig(encoding = "utf-8"))
		class FetchJeepTest {
//Step 8: Inject a TestRestTemplate in the test class. name the variable restTemplate. Inject the port used in 
// the test using the @localServerPort annotation . name the variable serverPort
// inject a  restRestTemplate
	
	
	
	
	
	     @Autowired
	     private TestRestTemplate restTemplate;
	     @LocalServerPort
	     private int serverPort;	
	     @Test
	     void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {// create a method in fetchJeepTest
//	Step 10 : Back in the test method that you were writing, create local variables for JeepModel, trim, and uri
	    	JeepModel model = JeepModel.WRANGLER;
			String trim = "Sport"; 
			String uri = String.format("http://localhost:%d/jeeps?model=%s&trim=%s", serverPort, model, trim); // uri is going to pass in model and trim  
// uri passes port/ jeep
// model, trim, 
// this uri prints the serves that tells the control the jeep with trim and model
//System.out.println(uri);
// when a connection is made to the uri
// getRestTemplate().getForEntity(uri, jeep.class);
// Step 11: a.	Send an HTTP request to the REST service that passes a JeepModel and trim level as URI parameters (as shown in the video)
		ResponseEntity<List<Jeep>> response = 	
				restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
// 	when a connection is made to the uri
// 	STEP 12:	Using a	AssertJ, test that the response that comes back from the server is 200 (success) – or as is shown in the video: HttpStatus.OK
// 	then : a success (ok - 200) status is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); 
// 	Assert j is a testing enviorment that has a lot of test that can be placed into  a project
//	assert that is how we suppose the result of the value should be

		//fail("Not yet implemented");
		}
	}


