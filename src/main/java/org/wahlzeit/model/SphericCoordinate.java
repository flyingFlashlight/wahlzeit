package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	
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
		//if(theta > Math.PI || theta < 0.0) {
		//	throw new IllegalArgumentException("theta out of value range");
		//}
		//if(phi < -Math.PI || phi > Math.PI) {
		//	throw new IllegalArgumentException("phi out of value range");
		//}
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		
		//Postcondition
		this.assertClassInvariants();
	}
	

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		//Invariant
		this.assertClassInvariants();
		
		double x = radius * Math.sin(theta) * Math.cos(phi);
		//System.out.print("[asCC()] x is " + x + "\n");
		double y = radius * Math.sin(theta) * Math.sin(phi);
		//System.out.print("[asCC()] y is " + y + "\n");
		double z = radius * Math.cos(theta);
		//System.out.print("[asCC()] z is " + z + "\n");
	
		//Postcondition
		CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
		tmp.assertClassInvariants();
		
		return tmp;
	}

	/*@Override
	public double getCartesianDistance(Coordinate point) {
		if(point == null) {
			throw new IllegalArgumentException("point must not be null");
		}
		//Goes to CArtesianCoordinate
		return this.asCartesianCoordinate().getCartesianDistance(point);
		
	}*/

	@Override
	public SphericCoordinate asSphericCoordinate() {
		//Precondition
		this.assertClassInvariants();
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		//Precondition
		assert coordinate != null;
		assert (coordinate instanceof SphericCoordinate);
		
		//if(coordinate == null) {
		//	throw new IllegalArgumentException("point must not be null");
		//}if(!(coordinate instanceof SphericCoordinate)) {
		//	throw new IllegalArgumentException("point must not a SphericCoordinate");
		//}
		SphericCoordinate tmp = (SphericCoordinate) coordinate;

		//Classinvariant
		tmp.assertClassInvariants();
		this.assertClassInvariants();
		
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
		//Precondition
		assert point != null;
		assert (point instanceof SphericCoordinate);
		
		//if(point == null) {
		//	throw new IllegalArgumentException("point must not be null");
		//} if (!(point instanceof SphericCoordinate)) {
		//	return false;
		//}
		SphericCoordinate sc = (SphericCoordinate) point;

		//Classinvariant
		sc.assertClassInvariants();		
		this.assertClassInvariants();
		
		return (this.phi == sc.phi && this.theta == sc.theta && this.radius == sc.radius);
	}
	
	public double getPhi() {
		assertPhi();
		return this.phi;
	}
	
	public double getTheta() {
		assertTheta();
		return this.theta;
	}
	
	public double getRadius() {
		assertRadius();
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
		point.assertClassInvariants();
		return this.isEqual(point);
	}
	
	public void assertRadius() {
		if(this.radius < 0.0) {
			throw new IllegalStateException("radius is less than zero");
		}
		
	}
	
	public void assertTheta() {
		if(this.theta > Math.PI || this.theta < 0.0) {
			throw new IllegalStateException("Theta has illegal value");
		} 
	}
	
	public void assertPhi() {
		if(this.phi < -Math.PI || this.phi > Math.PI) {
			throw new IllegalStateException("Phi has illegal value");
		}
	}
	
	public void assertClassInvariants() {
		assertRadius();
		assertTheta();
		assertPhi();
	}
}
