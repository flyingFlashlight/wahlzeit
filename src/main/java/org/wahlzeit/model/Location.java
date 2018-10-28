/*
 * Location
 * 
 * 10/23/2018
 * 
 * Copyright (c) by Stefan Zenk
 */


package org.wahlzeit.model;

public class Location {
	
	public Coordinate coordinate = null;
	
	public Location() {		
		coordinate = new Coordinate();
	}
	
	public Location(Coordinate coordinate) {		
		this.coordinate = coordinate;
	}
}
