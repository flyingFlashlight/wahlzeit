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
		this.inkColor = newInkColor;
	}

	/**
	 * @methodtype get
	 */
	public String getInkColor() {
		return this.inkColor;
	}
}
