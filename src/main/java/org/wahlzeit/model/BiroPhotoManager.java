package org.wahlzeit.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BiroPhotoManager extends PhotoManager{
	
	protected static final BiroPhotoManager instance = new BiroPhotoManager();
	private static final Logger log = Logger.getLogger(BiroPhotoManager.class.getName());
	/**
	 * In-memory cache for photos
	 */
	protected Map<PhotoId, BiroPhoto> photoCache = new HashMap<PhotoId, BiroPhoto>();
	
	
	public BiroPhotoManager() {
		photoTagCollector = BiroPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	public static final BiroPhotoManager getInstance() {
		return instance;
	}
	
	/**
	 * @methodtype get
	 * @methodproperties primitive
	 */
	@Override
	protected BiroPhoto doGetPhotoFromId(PhotoId id) {
		return this.photoCache.get(id);
	}
	/**
	 * @methodtype command
	 * @methodproperties primitive
	 */
	protected void doAddPhoto(BiroPhoto myPhoto) {
		myPhoto.manager = this;
		this.photoCache.put(myPhoto.getId(), myPhoto);
	}
	
	/**
	 * @methodtype boolean-query
	 * @methodproperty primitive
	 */
	@Override
	protected boolean doHasPhoto(PhotoId id) {
		return this.photoCache.containsKey(id);
	}
	
	/**
	 *
	 */
	@Override
	public void savePhotos() throws IOException{
		updateObjects(this.photoCache.values());
	}
	
	/**
	 * @methodtype get
	 */
	public Map<PhotoId, BiroPhoto> newGetPhotoCache() {
		return this.photoCache;
	}

}