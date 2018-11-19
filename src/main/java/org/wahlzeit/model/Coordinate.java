/*
 * Coordinate
 * 
 * 10/23/2018
 * 
 * Copyright (c) by Stefan Zenk
 */

package org.wahlzeit.model;

import java.math.*;

public interface Coordinate {
	
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate point);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getCentralAngle(Coordinate coordinate);
	
	public boolean isEqual(Coordinate point);
	
	
}
