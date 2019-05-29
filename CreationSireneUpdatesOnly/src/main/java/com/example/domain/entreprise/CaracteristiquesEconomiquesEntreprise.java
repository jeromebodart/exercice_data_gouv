package com.example.domain.entreprise;

public class CaracteristiquesEconomiquesEntreprise extends Entreprise {
	private String nature_juridique;
	private String lib_nature_juridique;
	private String activite_principale;
	private String lib_activite_principale;
	private String annee_validite;
	private String activite_principale_registre_metier;
	
	public CaracteristiquesEconomiquesEntreprise(String nature_juridique, String lib_nature_juridique, String activite_principale, String lib_activite_principale, String annee_validite, String activite_principale_registre_metier) {
		super();
		this.nature_juridique = nature_juridique;
		this.lib_nature_juridique = lib_nature_juridique;
		this.activite_principale = activite_principale;
		this.lib_activite_principale = lib_activite_principale;
		this.annee_validite = annee_validite;
		this.activite_principale_registre_metier = activite_principale_registre_metier;
	}
	public String getNature_juridique() {
		return nature_juridique;
	}
	public void setNature_juridique(String nature_juridique) {
		this.nature_juridique = nature_juridique;
	}
	public String getLib_nature_juridique() {
		return lib_nature_juridique;
	}
	public void setLib_nature_juridique(String lib_nature_juridique) {
		this.lib_nature_juridique = lib_nature_juridique;
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
	public String getAnnee_validite() {
		return annee_validite;
	}
	public void setAnnee_validite(String annee_validite) {
		this.annee_validite = annee_validite;
	}
	public String getActivite_principale_registre_metier() {
		return activite_principale_registre_metier;
	}
	public void setActivite_principale_registre_metier(String activite_principale_registre_metier) {
		this.activite_principale_registre_metier = activite_principale_registre_metier;
	}
	
}
