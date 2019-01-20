package org.wahlzeit.model;

import java.util.logging.Logger;

@PatternInstance(
	patternName = "Value Object",
	participants = {"SphericCoordinate", "CartesianCoordinate", "AbstractCoordiante"}
)

public class CartesianCoordinate extends AbstractCoordinate {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;

	private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());
	
	private CartesianCoordinate() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}
	//I think this will help me for following tasks
	private CartesianCoordinate(double x, double y, double z) throws IllegalStateException{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	
	public boolean isEqual(Coordinate point) throws IllegalArgumentException {
		//Precondition
		assertCoordNotNull(point);
		//assert point != null;
		assertInstance(point);
		//assert (point instanceof CartesianCoordinate);
	
		CartesianCoordinate sc = (CartesianCoordinate) point;
		return (this.x == sc.x && this.y == sc.y && this.z == sc.z);
	}
	
	
	//Aendert nicht den Zustand (Werte der Koordinaten) des Objektes
	public double computeRadiant(CartesianCoordinate point) throws IllegalArgumentException {
		//Precondition
		assertCoordNotNull(point);
		//assert point != null;
		//if(point == null) {
		//	throw new IllegalArgumentException("point must not be null");
		//}
		double radiant = 0;
		radiant += Math.pow((this.x - point.x), 2); 
		radiant += Math.pow((this.y - point.y), 2); 
		radiant += Math.pow((this.z - point.z), 2); 
		return radiant;
	}
	
	@Override
	public boolean equals(Object obj) throws IllegalArgumentException{
		//My implementation is inspired by this exmaple
		//https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java

		//assert obj != null;
		assertCoordNotNull((Coordinate) obj);
		assertInstance((Coordinate) obj);
		//assert (obj instanceof CartesianCoordinate);
		
		
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
		double theta = Math.acos((this.z/radius));
		double phi = 0.0;
		if(this.x == 0) {
			phi = (Math.signum(y)*(Math.PI/2));
		} else if(this.x > 0) {
			phi = Math.atan(y/x);
		} else {
			phi = Math.atan(this.y/this.x);
			if(this.y >= 0) {
				phi += Math.PI;
			} else {
				phi -= Math.PI;
			}
		}
		
		//TODO: Jetzt muessen wir hier den Vertrag erfuellen
		if(radius < 0) {
			radius = radius * -1;
		}
		
		if(theta < 0.0) {
			theta = theta * -1;
		}
		if(theta > Math.PI) {
			theta = theta % Math.PI;
		}
		
		phi = phi % Math.PI;
		
		SphericCoordinate tmp = SphericCoordinate.getSphericCoordinate(phi, theta, radius);
		tmp.assertClassInvariants();
		return tmp;
	}
	
	@Override
	public double getCentralAngle(Coordinate coordinate) {
		SphericCoordinate thisConverted = this.asSphericCoordinate();
		SphericCoordinate otherDude = coordinate.asSphericCoordinate();
		
		thisConverted.assertClassInvariants();
		otherDude.assertClassInvariants();
		
		return thisConverted.getCentralAngle(otherDude);
	}
	
	public void assertInstance(Coordinate coord) {
		if(!(coord instanceof CartesianCoordinate)) {
			log.info("assertInstance(): No argument given");
			throw new IllegalArgumentException("Argument is not instance of ");
		}
		
	}
	
	private static String generateSeedString(double a, double b, double c) {
		String seed = a + ":" + b + ":" + c + "C"; 
		return seed;
	}
	
	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		String key = generateSeedString(x, y, z);
		CartesianCoordinate result = (CartesianCoordinate) allCoordinates.get(key);
		if(result == null) {
			synchronized(CartesianCoordinate.class) {
				result = (CartesianCoordinate) allCoordinates.get(key);
				if(result == null) {
					result = new CartesianCoordinate(x, y, z);
					allCoordinates.put(key, result);
				}
			}
		}
		return result;
		
	}	
}
