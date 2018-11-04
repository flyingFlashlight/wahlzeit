/*
 * Location
 * 
 * 10/23/2018
 * 
 * Copyright (c) by Stefan Zenk
 */


package org.wahlzeit.model;

public class Location {
	
	private Coordinate coordinate = null;
	
	public Location() {		
		coordinate = new Coordinate();
	}
	
	public Location(Coordinate coordinate) {		
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
}
