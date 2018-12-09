package org.wahlzeit.model;

public class BiroPhoto extends Photo{
	
	

	public static final String NOTAVAILABLE = "n/a";
	
	//No explicit initialization like in other classes
	private String producer;
	private String advertiser;
	private String penColor;
	private String inkColor;
	
	/**
	 *
	 */
	public BiroPhoto() {
		super();
		this.setProducer(NOTAVAILABLE);
		this.setAdvertiser(NOTAVAILABLE);
		this.setPenColor(NOTAVAILABLE);
		this.setInkColor(NOTAVAILABLE);
	}
	/**
	 * @methodtype constructor
	 */
	public BiroPhoto(PhotoId myId) {
		super(myId);
		if(myId.value < 0) {
			throw new IllegalArgumentException("PhotoID must not be negative");
		}
		this.setProducer(NOTAVAILABLE);
		this.setAdvertiser(NOTAVAILABLE);
		this.setPenColor(NOTAVAILABLE);
		this.setInkColor(NOTAVAILABLE);
	}

	/**
	 * @methodtype constructor
	 */
	public BiroPhoto(String producer, String advertiser, String penColor, String inkColor) {
		super();
		this.setProducer(producer);
		this.setAdvertiser(advertiser);
		this.setPenColor(penColor);
		this.setInkColor(inkColor);
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
