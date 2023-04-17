// interface jeep sales controller is where we put all our documents
// tells spring hoe to map methods, this only works with the annotation inside 
// the implementing class not the interface



package com.promineotech.jeep.controller;
//	step 13:In this package, create an interface named 
// STEP 14: Add the class-level annotation @RequestMapping("/jeeps").

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
// request mapping annotation we map everything to /jeeps any uri with it will be connected to this class
// this "/jeep" is documentation to describe the control 





@RequestMapping("/jeeps")


// this  is like a chapter heading of a book  a chapter title 
//	step 16 : Add OpenAPI documentation to document the four possible outcomes: 
//	200 (success), 400 (bad input), 404 (not found) and 500 (unplanned error



@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = { 
		@Server(url = "http://localhost:8080", description = "local server.")})
public interface JeepSalesController {

	
	
//	"controllers are chapters"
//	a summary is a parameter to the operation annotation	
	
	@Operation( 
			summary = "Returns a list of Jeeps", // a summary is  ausmmary of what the oppreation does . 
			description= "Returns a list of Jeeps given an optional model and/or trim.", 
			responses = { // 4 responses ; success response,  bad format, parameter response a response if not found and one for if somthing  bad happens 
	
					
					
					
//	 note three take a comment but the last one
/////////////////////////// a context type is a mime type anything like; text/plain, xml application, Json image/jpeg
//////////////////////////	note: application/Json is what we choose for this content. evey 4 of them have the same content
/////////////////////////	@schema takes a parameter which is called an implementation			
			// 200 code is a sucess code       
			
					
			@ApiResponse ( responseCode = "200",
			description= "A list of Jeeps is returned", 
			content = @Content(mediaType = "application/json",
			schema = @Schema(implementation = Jeep.class))),
			
			
			
			//code 400 : illegal request 
			@ApiResponse( responseCode = "400",
			description = "The request parameters are invalid" ,
			content = @Content(mediaType = "application/json")),
			
			
			//code 404: not found
			@ApiResponse ( responseCode = "404",
			description = "No Jeeps were found with the input criteria",
			content = @Content(mediaType = "application/json")),
			
			
			
			// code 500: unplanned exception
			@ApiResponse ( responseCode= "500",
			description = "An unplanned error occurred" ,
			content = @Content(mediaType = "application/json"))
			},parameters = {
			
// 	if na empty value is imputed it will be replaced with an null
			
//	 if na empty value is imputed it will be replaced with an null
			
			@Parameter(name = "model",
						allowEmptyValue = false, 
					      required = false, 
					      description = "The model name (i.e., 'WRANGLER')"),
		    @Parameter(name = "trim", 
					     allowEmptyValue = false, 
					       required = false, 
					       description = "The trim level (i.e., 'Sport')")
			}
		)
	
// 	step 15:	Add the fetchJeeps method in a controller interface with the following signature:
//	Step 17:	Add the @GetMapping annotation and the @ResponseStatus(code = HttpStatus.OK) annotation as method-level annotations to the fetchJeeps method.

	
	
@GetMapping  // get a return of jeep , spring is then going to map the get request it to fetch jeeps method and return a response status.


// step 18: Add the @RequestParam annotations to the parameters 



@ResponseStatus(code = HttpStatus.OK) // if response status is success full, this class jeepsalecontroller , spring is going to map all requests with slash Jeep to this class

			List<Jeep> fetchJeeps(	
						@RequestParam JeepModel model,            //request param is named JeepModel if the name was not here it would inherit the parameter name
							@RequestParam String trim);	
// 	if everything is running we will get a 200 or ok message
}
