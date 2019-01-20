/*
 * CartesianCoordinateTest
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

public class CartesianCoordinateTest {
	private CartesianCoordinate coordinate;
	
	@Before
	public void initCoordinate() {
		coordinate = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
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
	public void testGetCartesianDistance() {
		Coordinate otherPoint = CartesianCoordinate.getCartesianCoordinate(0, 0, 2);
		assertTrue(2.0 == otherPoint.getCartesianDistance(coordinate));
	}
	
	@Test
	public void testIsEqual() {
		Coordinate pointA = CartesianCoordinate.getCartesianCoordinate(1, 2, 3);
		Coordinate pointB = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
		assertTrue(pointB.isEqual(coordinate));
		assertFalse(pointA.isEqual(coordinate));
		assertFalse(pointA.isEqual(pointB));
	}
	
	@Test
	public void testEquals() {
		Coordinate pointA = CartesianCoordinate.getCartesianCoordinate(1, 2, 3);
		Coordinate pointB = CartesianCoordinate.getCartesianCoordinate(0, 0, 0);
		assertTrue(pointB.equals(coordinate));
		assertFalse(pointA.equals(coordinate));
		assertFalse(pointA.equals(pointB));
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		assertTrue(coordinate.equals(coordinate.asCartesianCoordinate()));
	}
	
	@Test
	public void testAsSphericCoordinate() {
		SphericCoordinate sc = coordinate.asSphericCoordinate();
		assertNotNull(sc);
		
	}
	
	@Test
	public void testGetCentralAngle() {
		//Der einfachste Fall
		CartesianCoordinate cc = CartesianCoordinate.getCartesianCoordinate(1, 1, 1); 
		CartesianCoordinate cc2 = CartesianCoordinate.getCartesianCoordinate(1, 1, 1); 
		double angle = cc.getCentralAngle(cc2);
		System.out.println(angle);
		assertTrue(angle == 0.0);
	}

}
