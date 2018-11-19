package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;
	
	public CartesianCoordinate() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}
	//I think this will help me for following tasks
	public CartesianCoordinate(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	
	public double getCartesianDistance(Coordinate point) {
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		}
		CartesianCoordinate tmp = point.asCartesianCoordinate();
		return Math.sqrt(this.computeRadiant(tmp));
		
	}
	
	public boolean isEqual(Coordinate point) {
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		} if (!(point instanceof CartesianCoordinate)) {
			return false;
		}
		CartesianCoordinate sc = (CartesianCoordinate) point;
		return (this.x == sc.x && this.y == sc.y && this.z == sc.z);
	}
	
	
	private double computeRadiant(CartesianCoordinate point) {
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		}
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
		
		if(!(obj instanceof CartesianCoordinate)) {
			return false;
		}
		
		final CartesianCoordinate point = (CartesianCoordinate) obj;
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
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(((Math.pow(this.x, 2))+(Math.pow(this.y, 2))+(Math.pow(this.z, 2))));
		double theta = Math.toDegrees(Math.acos((this.z/radius)));
		double phi = 0.0;
		if(this.x == 0) {
			phi = Math.toDegrees((Math.signum(y)*(Math.PI/2)));
		} else if(this.x > 0) {
			phi = Math.toDegrees(Math.atan(y/x));
		} else {
			phi = Math.atan(this.y/this.x);
			if(this.y >= 0) {
				phi += Math.PI;
			} else {
				phi -= Math.PI;
			}
			phi = Math.toDegrees(phi);
		}
		
		return new SphericCoordinate(phi, theta, radius);
	}
	@Override
	public double getCentralAngle(Coordinate coordinate) {
		SphericCoordinate thisConverted = this.asSphericCoordinate();
		SphericCoordinate otherDude = coordinate.asSphericCoordinate();
		return thisConverted.getCentralAngle(otherDude);
	}
}
