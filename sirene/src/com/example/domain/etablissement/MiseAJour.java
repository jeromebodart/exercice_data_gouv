package com.example.domain.etablissement;

public class MiseAJour extends Etablissement {
	private String date;
	private String modification_activite_etablissement;
	private String modification_nature_etablissement;
	private String modification_entreprise;
	private String nature; 
	
	public MiseAJour(String nature, String modification_nature_etablissement, String modification_activite_etablissement, String modification_entreprise, String date) {
		super();
		this.nature= nature;
		this.date = date;
		this.modification_activite_etablissement = modification_activite_etablissement;
		this.modification_nature_etablissement = modification_nature_etablissement;
		this.modification_entreprise = modification_entreprise;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getModification_activite_etablissement() {
		return modification_activite_etablissement;
	}
	public void setModification_activite_etablissement(String modification_activite_etablissement) {
		this.modification_activite_etablissement = modification_activite_etablissement;
	}
	public String getModification_nature_etablissement() {
		return modification_nature_etablissement;
	}
	public void setModification_nature_etablissement(String modification_nature_etablissement) {
		this.modification_nature_etablissement = modification_nature_etablissement;
	}
	public String getModification_entreprise() {
		return modification_entreprise;
	}
	public void setModification_entreprise(String modification_entreprise) {
		this.modification_entreprise = modification_entreprise;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	
	
}
