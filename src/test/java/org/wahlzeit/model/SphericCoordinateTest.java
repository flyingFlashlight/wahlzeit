package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {
	private SphericCoordinate coordinate;
	
	@Before
	public void initCoordinate() {
		coordinate = SphericCoordinate.getSphericCoordinate(0, 0, 0);
	}

	@Test
	public void testConstructor() {
		//coordinate = new Coordinate();
		assertNotNull(coordinate);
		assertTrue(0.0 == coordinate.getPhi());
		assertTrue(0.0 == coordinate.getTheta());
		assertTrue(0.0 == coordinate.getRadius());
	}
	
	@Test
	public void testGetCentralAngle() {
	//	//Der einfachste Fall
		CartesianCoordinate cc = CartesianCoordinate.getCartesianCoordinate(1, 1, 1); 
		CartesianCoordinate cc2 = CartesianCoordinate.getCartesianCoordinate(1, 1, 1); 
		double angle = cc.getCentralAngle(cc2);
		System.out.println(angle);
		assertTrue(angle == 0.0);
	}
	
	//TODO: Machen
	@Test
	public void testGetCartesianDistance() {
		CartesianCoordinate otherPoint = CartesianCoordinate.getCartesianCoordinate(0, 0, 2);
		CartesianCoordinate otherPoint2 = CartesianCoordinate.getCartesianCoordinate(0, 0, 2);
		SphericCoordinate sc1 = otherPoint.asSphericCoordinate();
		SphericCoordinate sc2 = otherPoint2.asSphericCoordinate();
		System.out.println(sc1.getCartesianDistance(otherPoint));
		assertTrue(0 == sc1.getCartesianDistance(otherPoint));
	}
	
	@Test
	public void testIsEqual() {
		SphericCoordinate pointA = SphericCoordinate.getSphericCoordinate(1, 2, 3);
		SphericCoordinate pointB = SphericCoordinate.getSphericCoordinate(0, 0, 0);
		assertTrue(pointB.isEqual(coordinate));
		assertFalse(pointA.isEqual(coordinate));
		assertFalse(pointA.isEqual(pointB));
	}
	
	@Test
	public void testEquals() {
		SphericCoordinate pointA = SphericCoordinate.getSphericCoordinate(1, 2, 3);
		SphericCoordinate pointB = SphericCoordinate.getSphericCoordinate(0, 0, 0);
		CartesianCoordinate cc = CartesianCoordinate.getCartesianCoordinate(1, 2, 3);
		assertTrue(pointB.equals(coordinate));
		assertFalse(pointA.equals(coordinate));
		assertFalse(pointA.equals(pointB));
		assertFalse(pointA.equals(cc));
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		CartesianCoordinate ca = coordinate.asCartesianCoordinate();
		assertNotNull(ca);
		SphericCoordinate cc = SphericCoordinate.getSphericCoordinate(2, 3, 1);
		assertNotNull(cc);
		CartesianCoordinate sc = cc.asCartesianCoordinate();
		System.out.println("x = " + sc.getX());
		System.out.println("y = " + sc.getY());
		System.out.println("z = " + sc.getZ());
		assertTrue(sc.getX() == -0.05872664492762098);
		assertTrue(sc.getY() == 0.12832006020245673);
		assertTrue(sc.getZ() == -0.9899924966004454);
	}
	
	@Test
	public void testAsSphericCoordinate() {
		assertTrue(coordinate.equals(coordinate.asSphericCoordinate()));
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void testDBCConstructor() {
		SphericCoordinate pointA = SphericCoordinate.getSphericCoordinate(1, -5, 3);
	}
	
}
