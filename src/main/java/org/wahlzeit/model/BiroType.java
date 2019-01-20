package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BiroType {

	
	private String typeName;
	
	protected BiroType superType = null;
	protected Set<BiroType> subTypes = new HashSet<BiroType>();
	
	public BiroType getSuperType() {
		return this.superType;
	}
	
	public BiroType(String typeName) {
		this.typeName = typeName;
	}
	
	public Biro createInstance() {
		return new Biro(this);
	}
	
	public boolean isSubtype() {
		return (superType != null);
	}
	
	public Iterator<BiroType> getSubTypeIterator() {
		return subTypes.iterator();
	}
	
	public void addSubType(BiroType bt) {
		//assert (bt != null) : “tried to set null sub-type”;
		bt.setSuperType(this);
		subTypes.add(bt);
	}
	
	public void setSuperType(BiroType bt) {
		this.superType = bt;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
