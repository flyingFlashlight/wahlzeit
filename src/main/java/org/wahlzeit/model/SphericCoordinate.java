package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
	
	private double phi;
	private double theta;
	private double radius;
	

	public SphericCoordinate() {
		this.phi = 0.0;
		this.theta = 0.0;
		this.radius = 0.0;
	}
	
	//We work with degrees instead of radians
	public SphericCoordinate(double phi, double theta, double radius) {
		super();
		if(theta > Math.PI || theta < 0.0) {
			throw new IllegalArgumentException("theta out of value range");
		}
		if(phi < -Math.PI || phi > Math.PI) {
			throw new IllegalArgumentException("phi out of value range");
		}
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		//System.out.print("[asCC()] x is " + x + "\n");
		double y = radius * Math.sin(theta) * Math.sin(phi);
		//System.out.print("[asCC()] y is " + y + "\n");
		double z = radius * Math.cos(theta);
		//System.out.print("[asCC()] z is " + z + "\n");
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCartesianDistance(Coordinate point) {
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		}
		//Goes to CArtesianCoordinate
		return this.asCartesianCoordinate().getCartesianDistance(point);
		
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		if(coordinate == null) {
			throw new IllegalArgumentException("point must not be null");
		}if(!(coordinate instanceof SphericCoordinate)) {
			throw new IllegalArgumentException("point must not a SphericCoordinate");
		}
		SphericCoordinate tmp = (SphericCoordinate) coordinate;
		if(tmp.radius != this.radius) {
			//Two different versions of radius do not work
			return 0;
		}
		
		double beta1 = (this.theta);
		double beta2 = (tmp.theta);
		double alpha1 =  (this.phi);
		double alpha2 =  (tmp.phi);
		double innterValue = ((Math.cos(beta1) * Math.cos(beta2) * Math.cos((alpha1-alpha2))) + (Math.sin(beta1)*Math.sin(beta2)));
		double angle = Math.toDegrees(Math.acos(innterValue));
		return angle;
	}

	@Override
	public boolean isEqual(Coordinate point) {
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		} if (!(point instanceof SphericCoordinate)) {
			return false;
		}
		SphericCoordinate sc = (SphericCoordinate) point;
		return (this.phi == sc.phi && this.theta == sc.theta && this.radius == sc.radius);
	}
	
	public double getPhi() {
		return this.phi;
	}
	
	public double getTheta() {
		return this.theta;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		//My implementation is inspired by this exmaple
		//https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof SphericCoordinate)) {
			return false;
		}
		
		final SphericCoordinate point = (SphericCoordinate) obj;
		return this.isEqual(point);
	}
}
