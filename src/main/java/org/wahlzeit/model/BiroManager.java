package org.wahlzeit.model;

import java.util.Hashtable;

public class BiroManager {
	//Sehr stark an Foliena ngelehnt
	private Hashtable<Integer, Biro> biros = new Hashtable<Integer, Biro>();
	private Hashtable<String, BiroType> birotypes = new Hashtable<String, BiroType>();
	
	public Biro createBiro(String typeName) {
		assertCorrectParameters(typeName);
		BiroType bt = getBiroType(typeName);
		Biro result = bt.createInstance();
		biros.put(result.hashCode(), result);
		return result;
	}
	
	private BiroType getBiroType(String typename) {
		BiroType result = null;
		synchronized(BiroManager.class) {
			result = birotypes.get(typename);
		}
		if(result == null) {
			result = new BiroType(typename);
			birotypes.put(typename, result);
		} 
		return result;
	}
	
	public void assertCorrectParameters(String tmp) {
		//TODO: noch machen
		
	}
}
