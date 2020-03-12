package com.bibliotheque.util;

public enum EnumStatusExemplaire {
	PRETE("PRETE"), DISPONIBLE("DISPONIBLE"), SUPPRIME("SUPPRIME");

	private String description;

	private EnumStatusExemplaire(String description) {
		this.description = description;
	}

	public String getValue() {
		return name();
	}
	public void setValue(String value) {}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
