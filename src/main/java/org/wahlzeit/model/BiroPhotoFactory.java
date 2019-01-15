package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

@PatternInstance(
		patternName = "Abstract Factory",
		participants = {"BiroPhotoFactory", "BiroPhoto", "PhotoFactory", "Photo"}
)

public class BiroPhotoFactory extends PhotoFactory{
	
	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());

	private static BiroPhotoFactory instance = null;
	/**
	 * @method_type constructor
	 */
	protected BiroPhotoFactory() {
		super();
		//Do nothing
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized BiroPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
			setInstance(new BiroPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(BiroPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public BiroPhoto createPhoto() throws IllegalArgumentException{
		return new BiroPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public BiroPhoto createPhoto(PhotoId id) throws IllegalArgumentException{
		return new BiroPhoto(id);
	}
	
	/**
	 * 
	 */
	@Override
	public BiroPhoto loadPhoto(PhotoId id) {
		return null;
	}

	

}