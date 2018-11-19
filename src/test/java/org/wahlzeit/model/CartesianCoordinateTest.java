/*
 * CoordinateTest
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

public class CoordinateTest {
	private Coordinate coordinate;
	
	@Before
	public void initCoordinate() {
		coordinate = new Coordinate();
	}
	
	@Test
	public void testConstructor() {
		//coordinate = new Coordinate();
		assertNotNull(coordinate);
		assertTrue(0.0 == coordinate.getX());
		assertTrue(0.0 == coordinate.getY());
		assertTrue(0.0 == coordinate.getZ());
	}
	
	@Test
	public void testGetDistance() {
		Coordinate otherPoint = new Coordinate(0, 0, 2);
		assertTrue(2.0 == otherPoint.getDistance(coordinate));
	}
	
	@Test
	public void testIsEqual() {
		Coordinate pointA = new Coordinate(1, 2, 3);
		Coordinate pointB = new Coordinate(0, 0, 0);
		assertTrue(pointB.isEqual(coordinate));
		assertFalse(pointA.isEqual(coordinate));
		assertFalse(pointA.isEqual(pointB));
	}
	
	@Test
	public void testEquals() {
		Coordinate pointA = new Coordinate(1, 2, 3);
		Coordinate pointB = new Coordinate(0, 0, 0);
		assertTrue(pointB.equals(coordinate));
		assertFalse(pointA.equals(coordinate));
		assertFalse(pointA.equals(pointB));
		
	}

}
