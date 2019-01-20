/*
 * Location
 * 
 * 10/23/2018
 * 
 * Copyright (c) by Stefan Zenk
 */


package org.wahlzeit.model;

import java.util.logging.Logger;

public class Location {
	
	private Coordinate coordinate = null;

	private static final Logger log = Logger.getLogger(Location.class.getName());
	
	public Location() {
		int i = 0;
		for(i = 0; i < 3; i++) {
			try {
				coordinate = CartesianCoordinate.getCartesianCoordinate(1, 2, 3);
				break;
			} catch(IllegalArgumentException e){
				//Next Round in loop
			}
		}
		if(i == 3) {
			log.info("Location(): Could not initialize coordinate");
			throw new IllegalStateException("Could not initialize coordinate");
		}
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
