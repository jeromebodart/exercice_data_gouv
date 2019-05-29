package com.example.domain.etablissement;

public class CaracteristiquesEconomiquesEtablissement extends Etablissement {
	private String nature;
	private String lib_nature;
	private String activite_principale;
	private String lib_activite_principale;
	
	public CaracteristiquesEconomiquesEtablissement(String nature, String lib_nature, String activite_principale, String lib_activite_principale) {
		super();
		this.nature = nature;
		this.lib_nature = lib_nature;
		this.activite_principale = activite_principale;
		this.lib_activite_principale = lib_activite_principale;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getLib_nature() {
		return lib_nature;
	}
	public void setLib_nature(String lib_nature) {
		this.lib_nature = lib_nature;
	}
	public String getActivite_principale() {
		return activite_principale;
	}
	public void setActivite_principale(String activite_principale) {
		this.activite_principale = activite_principale;
	}
	public String getLib_activite_principale() {
		return lib_activite_principale;
	}
	public void setLib_activite_principale(String lib_activite_principale) {
		this.lib_activite_principale = lib_activite_principale;
	}
	
}
