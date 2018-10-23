/*
 * Coordinate
 * 
 * 10/23/2018
 * 
 * Copyright (c) by Stefan Zenk
 */

package org.wahlzeit.model;

import java.math.*;

public class Coordinate {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;
	
	public Coordinate() {
		super();
	}
	
	//I think this will help me for following tasks
	public Coordinate(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected double getDistance(Coordinate point) {
		return Math.sqrt(this.multiply(point));
		
	}
	
	protected boolean isEqual(Coordinate point) {
		return (this.x == point.x && this.y == point.y && this.z == point.z);
	}
	
	private double multiply(Coordinate point) {
		double erg = 0;
		erg += (this.x * point.x);
		erg += (this.y * point.y);
		erg += (this.z * point.z);
		return erg;		
	}
	
	@Override
	public boolean equals(Object obj) {
		//My implementation is inspired by this exmaple
		//https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
		if(obj == null) {
			return false;
		}
		
		if(!Coordinate.class.isInstance(obj.getClass())) {
			return false;
		}
		
		final Coordinate point = (Coordinate) obj;
		return this.isEqual(point);
	}
}
