package com.promineotech.jeep.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest   //mock mbc object will run and configure 
@AutoConfigureMockMvc
class ImageUploadTest {
	//mock mbc object
	private MockMvc mockMvc; //throw request to http
	
	
	@Test
	void testThatTheServerCorrectlyRecievesAnImageAndReturnsAnOKResponse(){
		//reads image resource path
		//Resource image = ne)
	}
	
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
