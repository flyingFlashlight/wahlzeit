package org.wahlzeit.model;

import java.util.logging.Logger;


@PatternInstance(
	patternName = "Value Object",
	participants = {"SphericCoordinate", "CartesianCoordinate", "AbstractCoordiante"}
)

public class SphericCoordinate extends AbstractCoordinate {
	
	private double phi;
	private double theta;
	private double radius;


	private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());
	

	public SphericCoordinate() {
		this.phi = 0.0;
		this.theta = 0.0;
		this.radius = 0.0;
	}
	
	//We work with degrees instead of radians
	public SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException{
		super();
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		
		//Postcondition
		this.assertClassInvariants();
	}
	

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException{
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

	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException{
		//Precondition
		this.assertClassInvariants();
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) throws IllegalStateException, IllegalArgumentException{
		//Precondition
		this.assertCoordNotNull(coordinate);
		//assert coordinate != null;
		assertInstance(coordinate);
		//assert (coordinate instanceof SphericCoordinate);
		
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
	public boolean isEqual(Coordinate point) throws IllegalStateException, IllegalArgumentException{
		//Precondition
		assertCoordNotNull(point);
		//assert point != null;
		assertInstance(point);
		//assert (point instanceof SphericCoordinate);
		
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
			log.info("assertRadius: radius is less than zero");
			throw new IllegalStateException("radius is less than zero");
		}
		
	}
	
	public void assertTheta() {
		if(this.theta > Math.PI || this.theta < 0.0) {
			log.info("assertTheta: Theta has illegal value");
			throw new IllegalStateException("Theta has illegal value");
		} 
	}
	
	public void assertPhi() {
		if(this.phi < -Math.PI || this.phi > Math.PI) {
			log.info("assertPhi: Phi has illegal value");
			throw new IllegalStateException("Phi has illegal value");
		}
	}
	
	public void assertClassInvariants() throws IllegalStateException{
		assertRadius();
		assertTheta();
		assertPhi();
	}
	
	public void assertInstance(Coordinate coord) {
		if(!(coord instanceof SphericCoordinate)) {
			log.info("assertInstance: Argument is no instance of SphericCoordinate");
			throw new IllegalArgumentException("Argument is no instance of SphericCoordinate");
		}
		
	}
}
