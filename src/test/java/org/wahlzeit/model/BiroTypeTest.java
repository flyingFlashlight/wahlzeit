package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BiroTypeTest {
	private BiroType bt = null;
	private BiroType bt2 = null;
	
	@Before
	public void initBiroType() {
		bt = new BiroType("Test");
		bt2 = new BiroType("Test2");
	}
	
	@Test
	public void testIsSubType() {
		assertFalse(bt.isSubtype());
		bt.addSubType(bt2);
		assertTrue(bt2.isSubtype());
	}

}
