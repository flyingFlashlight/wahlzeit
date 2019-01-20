package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BiroPhotoManagerTest {
	private BiroPhotoManager bpm = null;
	private BiroPhoto biroPhoto = null;
	private BiroManager manager = null;
	
	@Before
	public void initBiroPhoto() {
		bpm = BiroPhotoManager.getInstance();
		manager = new BiroManager();
		
	}
	
	@Test
	public void testInitConstructors() {
		Biro test = manager.createBiro("Type1");
		assertNotNull(test);
		//BiroPhoto biroPhoto2 = new BiroPhoto(PhotoId.getNextId());
		//BiroPhoto biroPhoto3 = new BiroPhoto("KulliGMBH", "WerbeAG", "blau", "schwarz");
		//assertNotNull(bpm);
	}
}