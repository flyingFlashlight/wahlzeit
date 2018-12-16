package org.wahlzeit.model;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.logging.Logger;

public abstract class AbstractCoordinate implements Coordinate {

	private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());
	private Hashtable<Integer, Coordinate> allCoordinates = new Hashtable<Integer, Coordinate>();

	
	public double getCartesianDistance(Coordinate point) throws IllegalArgumentException{
		assert point != null;
		//if(point == null) {
		//	throw new IllegalArgumentException("point must not be null");
		//}
		CartesianCoordinate tmp = point.asCartesianCoordinate();
		CartesianCoordinate thisTmp = this.asCartesianCoordinate();
		tmp.assertClassInvariants();
		tmp.assertClassInvariants();
		
		return Math.sqrt(thisTmp.computeRadiant(tmp));
	}
	
	public void assertClassInvariants() throws IllegalStateException{
	}
	
	public void assertCoordNotNull(Coordinate coord) {
		if(coord == null) {
			log.info("assertCoordNotNull(): No argument given");
			throw new IllegalArgumentException("No argument given");
		}
	}	
	
}
