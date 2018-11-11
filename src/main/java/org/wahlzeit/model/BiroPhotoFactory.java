package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

public class BiroPhotoFactory extends PhotoFactory{
	
	

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
	public Photo createPhoto() {
		return new BiroPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
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
