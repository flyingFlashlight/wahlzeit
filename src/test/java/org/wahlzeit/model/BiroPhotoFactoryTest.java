package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BiroPhotoFactoryTest {
	
	private BiroPhotoFactory bpf = null;
	
	@Before
	public void initBiroPhotoFactory() {
		bpf = BiroPhotoFactory.getInstance();
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(bpf);
	}
	
	@Test
	public void testCreatePhoto() {
		PhotoId pid = PhotoId.getNextId();
		assertNull(bpf.loadPhoto(pid));
		assertNotNull(bpf.createPhoto());
		assertNotNull(bpf.createPhoto(pid));
	}
	
	@Test
	public void testInheritance() {
		assertNotNull(bpf.createPhotoFilter());
		assertNotNull(bpf.createPhotoTagCollector());
	}

}
