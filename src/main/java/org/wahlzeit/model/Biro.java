package org.wahlzeit.model;

public class Biro {
	public Location location;
	public BiroType type;
	public BiroPhoto photo;
	
	//Diese Attribute gehoeren einfach zu JEDEM Kugelschreiber
	private String producer;
	private String advertiser;
	private String penColor;
	private String inkColor;
	
	public static final String NOTAVAILABLE = "n/a";
	
	protected Biro(BiroType bt) {
		this.type = bt;
		this.producer = Biro.NOTAVAILABLE;
		this.advertiser = Biro.NOTAVAILABLE;
		this.penColor = Biro.NOTAVAILABLE;
		this.inkColor = Biro.NOTAVAILABLE;
	}
		
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setType(BiroType type) {
		this.type = type;
	}
	
	public BiroType getType() {
		return this.type;
	}
	
	/**
	 * @methodtype set
	 */
	public void setProducer(String newProducer) {
		this.producer = newProducer;
	}
	
	/**
	 * @methodtype get
	 */
	public String getProducer() {
		return this.producer;
	}
	
	/**
	 * @methodtype set
	 */
	public void setAdvertiser(String newAdvertiser) {
		if(newAdvertiser == null) {
			throw new IllegalArgumentException("Advertiser must not be null");
		}
		this.advertiser = newAdvertiser;
	}
	
	/**
	 * @methodtype get
	 */
	public String getAdvertiser() {
		return this.advertiser;
	}
	
	/**
	 * @methodtype set
	 */
	public void setPenColor(String newPenColor) {
		if(newPenColor == null) {
			throw new IllegalArgumentException("Pencolor must not be null");
		}
		this.penColor = newPenColor;
	}

	/**
	 * @methodtype get
	 */
	public String getPenColor() {
		return this.penColor;
	}

	/**
	 * @methodtype set
	 */
	public void setInkColor(String newInkColor) {
		if(newInkColor == null) {
			throw new IllegalArgumentException("InkColor must not be null");
		}
		this.inkColor = newInkColor;
	}

	/**
	 * @methodtype get
	 */
	public String getInkColor() {
		return this.inkColor;
	}

}
