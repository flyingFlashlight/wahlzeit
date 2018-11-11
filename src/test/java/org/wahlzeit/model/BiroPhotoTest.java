package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BiroPhotoTest {
	
	private BiroPhoto biroPhoto = null;
	
	@Before
	public void initBiroPhoto() {
		biroPhoto = new BiroPhoto();
	}
	
	@Test
	public void testInitConstructors() {
		BiroPhoto biroPhoto2 = new BiroPhoto(PhotoId.getNextId());
		BiroPhoto biroPhoto3 = new BiroPhoto("KulliGMBH", "WerbeAG", "blau", "schwarz");
		assertNotNull(biroPhoto);
		assertNotNull(biroPhoto2);
		assertNotNull(biroPhoto3);
		assertEquals("KulliGMBH", biroPhoto3.getProducer());
		assertEquals("WerbeAG", biroPhoto3.getAdvertiser());
		assertEquals("blau", biroPhoto3.getPenColor());
		assertEquals("schwarz", biroPhoto3.getInkColor());
	}
	
	@Test
	public void testGetterAndSetter() {
		String dummy = "Kukkies";
		biroPhoto.setAdvertiser(dummy);
		assertEquals(dummy, biroPhoto.getAdvertiser());
		biroPhoto.setProducer(dummy);
		assertEquals(dummy, biroPhoto.getProducer());
		biroPhoto.setInkColor(dummy);
		assertEquals(dummy, biroPhoto.getInkColor());
		biroPhoto.setPenColor(dummy);
		assertEquals(dummy, biroPhoto.getPenColor());
	}
	
	@Test
	public void testDefaultConstructor() {
		assertEquals(BiroPhoto.NOTAVAILABLE, biroPhoto.getAdvertiser());
		assertEquals(BiroPhoto.NOTAVAILABLE, biroPhoto.getProducer());
		assertEquals(BiroPhoto.NOTAVAILABLE, biroPhoto.getInkColor());
		assertEquals(BiroPhoto.NOTAVAILABLE, biroPhoto.getPenColor());
	}
	

}
