package edu.mum.mumscrum.s5.entity;

public abstract class AbstractEntity {
	public String getId() {
		return getEntityPrimaryKey();
	}
	
	protected abstract String getEntityPrimaryKey();
}
