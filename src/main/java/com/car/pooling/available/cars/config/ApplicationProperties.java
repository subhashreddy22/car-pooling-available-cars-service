package com.car.pooling.available.cars.config;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The Class ApplicationProperties to read values form properties.
 */
@Component
@ConfigurationProperties
public class ApplicationProperties {

	/** The Constant LOGGER to log the data. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);

	/**
	 * The availableCarsMap.
	 * This is the map which contains location as key and list of
	 * cars as value.
	 * This is read from application.yml
	 */
	private HashMap<String, List<String>> availableCarsMap;

	/**
	 * Gets the available cars map.
	 *
	 * @return the available cars map
	 */
	public HashMap<String, List<String>> getAvailableCarsMap() {
		return availableCarsMap;
	}

	/**
	 * Sets the available cars map.
	 *
	 * @param availableCarsMap the available cars map
	 */
	public void setAvailableCarsMap(HashMap<String, List<String>> availableCarsMap) {
		this.availableCarsMap = availableCarsMap;
	}

	/**
	 * Post construct.
	 * 
	 * To log the availableCarsMap on console
	 */
	@PostConstruct
	public void postConstruct() {
		LOGGER.info("The locations map loaded form properties {}", availableCarsMap);
	}
}
