package com.car.pooling.available.cars.controller;

import java.util.List;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car.pooling.available.cars.config.ApplicationProperties;

/**
 * The Class AvailableCarsController.
 */
@RestController
class AvailableCarsController {

	/** The Constant LOGGER to log the data. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AvailableCarsController.class);

	/**
	 * The properties.
	 * This autowires the properties from application.yml to this class.
	 * 
	 */
	@Autowired
	private ApplicationProperties properties;

	/**
	 * Gets the available cars.
	 * Receives location as input
	 * Returns the list of cars in that location.
	 * 
	 * This a GET method with URI /car/pooling/available/cars
	 * Please refer README.md for further info
	 *
	 * @param location the location
	 * @return the available cars at that location
	 */
	@GetMapping(value = "/car/pooling/available/cars", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAvailableCars(@RequestParam String location) {
		//this converts the map into a case insensitive map so the keys become case insensitive
		CaseInsensitiveMap<String, List<String>> carsMap = new CaseInsensitiveMap<>(properties.getAvailableCarsMap());
		//this retrieves the list of cars from the map. 
		List<String> carsList = carsMap.get(location);
		//Logs the location and list of cars
		LOGGER.info("List of cars in the location {} -> {}", location, carsList);
		//returns the list of cars
		return carsList;
	}
}
