package com.car.pooling.available.cars;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * The Class CarPoolingAvailableCarsServiceApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarPoolingAvailableCarsServiceApplication.class)
@WebAppConfiguration
public class CarPoolingAvailableCarsServiceApplicationTests {

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {

	}

	/**
	 * Given location 
	 * When location is Germany 
	 * Then success response
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void successGermanyTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/car/pooling/available/cars").param("location", "Germany"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	/**
	 * Given location 
	 * When location is Portugal 
	 * Then success response
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void successPortugalTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/car/pooling/available/cars").param("location", "Portugal"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	/**
	 * Given location 
	 * When location is UK 
	 * Then success response
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void successUKTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/car/pooling/available/cars").param("location", "UK"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	/**
	 * Given location 
	 * When location is Turkey 
	 * Then success response
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void successTurkeyTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/car/pooling/available/cars").param("location", "Turkey"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	/**
	 * Given location 
	 * When location does not match any country
	 * Then empty response
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void failureTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/car/pooling/available/cars").param("location", "junk"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertThat(mvcResult.getResponse().getContentAsString(), CoreMatchers.is(""));
    }

}
