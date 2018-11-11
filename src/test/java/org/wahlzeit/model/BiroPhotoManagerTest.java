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
	
	@Before
	public void initBiroPhoto() {
		bpm = BiroPhotoManager.getInstance();
	}
	
	@Test
	public void testInitConstructors() {
		BiroPhoto biroPhoto2 = new BiroPhoto(PhotoId.getNextId());
		BiroPhoto biroPhoto3 = new BiroPhoto("KulliGMBH", "WerbeAG", "blau", "schwarz");
		assertNotNull(bpm);
	}
}
