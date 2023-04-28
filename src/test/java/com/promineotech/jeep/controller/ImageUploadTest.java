package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
//import org.springfradmework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest   //mock mbc object will run and configure 
@AutoConfigureMockMvc
class ImageUploadTest {
	
	private static final String JEEP_IMAGE = "Jeep Wrangler Rubicon.jpg";
	
	
	//mock mbc object
	@Autowired
	//mock mvc object
	private MockMvc mockMvc; //throw request to http
	
	
	@Test
	//tittle the test so this so we can recieve the image 
	void testThatTheServerCorrectlyRecievesAnImageAndReturnsAnOKResponse() throws Exception{
		//reads image resource path
		//Resource image = ne)
		Resource image = new ClassPathResource(JEEP_IMAGE);
		//Resource image = new ClassPathResource(JEEP_IMAGE);
		
		if(!image.exists()) { 
			fail("could not find respurce %s", JEEP_IMAGE);
		}
	
	 try(InputStream inputStream = image.getInputStream()){
		MockMultipartFile file = new MockMultipartFile("image",JEEP_IMAGE, 
				MediaType.TEXT_PLAIN_VALUE, inputStream);
		 //@formatter:off
	MvcResult result = mockMvc
			.perform(MockMvcRequestBuilders
					.multipart("/jeeps/1/image")
					.file(file))
			.andDo(print())
			.andExpect(status().is(201))
			.andReturn();
		 
		 //@formatter:on
	String content = result.getResponse().getContentAsString();
	assertThat(content).isNotEmpty();
	
	 }
	

//	@Test
//	void test() {
//		fail("Not yet implemented");
	}

}
