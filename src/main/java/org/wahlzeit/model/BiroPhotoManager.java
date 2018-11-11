package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class BiroPhotoManager extends PhotoManager{
	

	protected static final BiroPhotoManager instance = new BiroPhotoManager();
	/**
	 * In-memory cache for photos
	 */
	protected Map<PhotoId, BiroPhoto> photoCache = new HashMap<PhotoId, BiroPhoto>();
	
	/**
	 * @methodtype get
	 * @methodproperties primitive
	 */
	protected BiroPhoto doGetPhotoFromId(PhotoId id) {
		return photoCache.get(id);
	}

	/**
	 * @methodtype command
	 * @methodproperties primitive
	 */
	protected void doAddPhoto(BiroPhoto myPhoto) {
		photoCache.put(myPhoto.getId(), myPhoto);
	}

	//You can overwrite final functions
	/**
	 * @methodtype get
	 */
	/*public final BiroPhoto getPhoto(String id) {
		return getPhoto(PhotoId.getIdFromString(id));
	}	
	/**
	 * @methodtype get
	 
	public final BiroPhoto getPhoto(PhotoId id) {
		return instance.getPhotoFromId(id);
	}*/
}
