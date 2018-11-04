/*
 * LocationTest
 * 
 * 10/28/2018
 * 
 * Copyright (c) by Stefan Zenk
 */
package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LocationTest {
	private Location location;
	
	@Before
	public void initLocation(){
		location = new Location();
	}
	
	@Test
	public void testConstructor(){
		assertNotNull(location);
		assertNotNull(location.getCoordinate());
	}
	
	@Test
	public void testInitiatedConstructor(){
		Coordinate coordinate = new Coordinate(1, 5, 2);
		location = new Location(coordinate);
		assertTrue(coordinate.equals(location.getCoordinate()));
	}

}
