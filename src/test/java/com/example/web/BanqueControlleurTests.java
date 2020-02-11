package com.example.web;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hibernate.type.TrueFalseType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(BanqueControlleur.class)
public class BanqueControlleurTests {

	  @Autowired
	   MockMvc mockMvc;
	
 @Test
  public void homeTest() throws Exception {
	  
		/*
		 * mockMvc.perform(get("/ConsulteSold"))
		 * .andExpect(status().isOk()).andExpect((ResultMatcher)
		 * content().string("tete"));
		 */
	  
		/*
		 * mockMvc.perform(get("/Verser")) .andExpect(status().isOk());
		 * 
		 * mockMvc.perform(get("/retirer")) .andExpect(status().isOk());
		 * 
		 * 
		 * mockMvc.perform(get("/virer")) .andExpect(status().isOk());
		 */
  }

	  
}
