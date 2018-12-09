package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	public double getCartesianDistance(Coordinate point) {
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
	
	public void assertClassInvariants() {
	}
	
	public void assertCoordNotNull(Coordinate coord) {
		assert coord != null;
	}
}
