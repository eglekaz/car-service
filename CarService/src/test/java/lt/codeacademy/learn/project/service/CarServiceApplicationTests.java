package lt.codeacademy.learn.project.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import lt.codeacademy.learn.project.controllers.CustomerController;
import lt.codeacademy.learn.project.controllers.MainController;
import lt.codeacademy.learn.project.controllers.ServiceAdvisorController;
import lt.codeacademy.learn.project.controllers.TechnicianController;

@SpringBootTest
@AutoConfigureMockMvc //TODO 1
//@ExtendWith(SpringExtension.class)
class CarServiceApplicationTests {

	@Autowired
	MainController mainController;
	    
	@Autowired
	CustomerController custController;
	
	@Autowired
	ServiceAdvisorController servAdController;
	
	@Autowired
	TechnicianController techController;
	
	@Autowired  //TODO 2
	private MockMvc mockMvc;

	@Test
	void itShouldCheckIfMainControllerLoads() {
	    assertThat(mainController).isNotNull();
	}
	    
	@Test
	void itShouldCheckIfCustomerControllerLoads() {
	    assertThat(custController).isNotNull();
	}
	
	@Test
	void itShouldCheckIfServiceAdvisorControllerLoads() {
	    assertThat(servAdController).isNotNull();
	}
	
	@Test
	void itShouldCheckIfTechnicianControllerLoads() {
	    assertThat(techController).isNotNull();
	}
	
	@Test
	void itShouldRedirectWhenUnAuthenticated() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/service-advisor/all"))
				.andExpect(redirectedUrl("http://localhost/login"));
		// @formatter:on
	}
	
	@Test
	@Transactional
	@WithMockUser(roles="ADMIN")
	void itShouldGiveOkStatusWhenAuthenticated() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/service-advisor/all"))
				.andExpect(status().isOk());
		// @formatter:on
	}

}

