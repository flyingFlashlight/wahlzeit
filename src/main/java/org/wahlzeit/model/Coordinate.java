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
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}
	
	//I think this will help me for following tasks
	public Coordinate(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected double getDistance(Coordinate point) {
		return Math.sqrt(this.computeRadiant(point));
		
	}
	
	protected boolean isEqual(Coordinate point) {
		return (this.x == point.x && this.y == point.y && this.z == point.z);
	}
	
	
	private double computeRadiant(Coordinate point) {
		double radiant = 0;
		radiant += Math.pow((this.x - point.x), 2); 
		radiant += Math.pow((this.y - point.y), 2); 
		radiant += Math.pow((this.z - point.z), 2); 
		return radiant;
	}
	
	@Override
	public boolean equals(Object obj) {
		//My implementation is inspired by this exmaple
		//https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof Coordinate)) {
			return false;
		}
		
		final Coordinate point = (Coordinate) obj;
		return this.isEqual(point);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
}
