package com.example.domain.entreprise;

public class IdentificationEntreprise extends Entreprise {
	private Long id;
	private String raison_sociale;
	private String sigle;
	private String nom;
	private String prenom;
	private String civilite;
	private String repertoire_nationale_associations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRaison_sociale() {
		return raison_sociale;
	}
	public void setRaison_sociale(String raison_sociale) {
		this.raison_sociale = raison_sociale;
	}
	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getRepertoire_nationale_associations() {
		return repertoire_nationale_associations;
	}
	public void setRepertoire_nationale_associations(String repertoire_nationale_associations) {
		this.repertoire_nationale_associations = repertoire_nationale_associations;
	}
	
}
