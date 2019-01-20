package org.wahlzeit.model;

public class BiroType {

	
	private String typeName;
	
	public BiroType(String typeName) {
		this.typeName = typeName;
	}
	
	public Biro createInstance() {
		return new Biro(this);
	}
	
	public boolean isSubtype() {
		//TODO: Implement
		return false;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
