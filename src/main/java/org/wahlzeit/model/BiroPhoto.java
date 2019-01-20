package org.wahlzeit.model;

import java.util.logging.Logger;

@PatternInstance(
	patternName = "Abstract Factory",
	participants = {"BiroPhotoFactory", "BiroPhoto", "PhotoFactory", "Photo"}
)

public class BiroPhoto extends Photo{
	public Biro biro;
	public BiroPhotoManager manager;
	
	private static final Logger log = Logger.getLogger(BiroPhoto.class.getName());
	
	
	/**
	 *
	 */
	public BiroPhoto() {
		super();
	}
	/**
	 * @methodtype constructor
	 */
	public BiroPhoto(PhotoId myId) {
		super(myId);
		if(myId.value < 0) {
			log.info("BiroPhoto: PhotoID must not be negative");
			throw new IllegalArgumentException("PhotoID must not be negative");
		}
	}
	
	public void addBiro(Biro newBiro) {
		this.biro = newBiro;
		this.biro.photo = this;
	}
}
