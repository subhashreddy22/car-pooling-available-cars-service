package com.car.pooling.available.cars.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.car.pooling.available.cars.config.ApplicationProperties;

/**
 * The Class AvailableCarsControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class AvailableCarsControllerTest {
	
	/** The properties. */
	@Mock
	private ApplicationProperties properties;
	
	/** The controller. */
	@InjectMocks
	private AvailableCarsController controller;
	
	/**
	 * Inits the properties.
	 */
	@Before
	public void init() {
		HashMap<String, List<String>> availableCarsMap = new HashMap<>();
		availableCarsMap.put("location1", Arrays.asList("Car1", "Car2", "Car3"));
		availableCarsMap.put("location2", Arrays.asList("Car4", "Car5"));
		when(properties.getAvailableCarsMap()).thenReturn(availableCarsMap);
	}
	
	/**
	 * Given location
	 * When it is location1
	 * Then return car list of size 3
	 *
	 * @return the available cars success test 1
	 */
	@Test
	public void getAvailableCarsSuccessTest1() {
		List<String> availableCars = controller.getAvailableCars("location1");
		assertThat(availableCars.size(), is(3));
	}
	
	/**
	 * Given location
	 * When it is location2
	 * Then return car list of size 2
	 *
	 * @return the available cars success test 2
	 */
	@Test
	public void getAvailableCarsSuccessTest2() {
		List<String> availableCars = controller.getAvailableCars("location2");
		assertThat(availableCars.size(), is(2));
	}
	
	/**
	 * Given location
	 * When it is not available in map
	 * Then return null car list
	 *
	 * @return the available cars fail test
	 */
	@Test
	public void getAvailableCarsFailTest() {
		List<String> availableCars = controller.getAvailableCars("location3");
		assertThat(availableCars, nullValue());
	}
}
