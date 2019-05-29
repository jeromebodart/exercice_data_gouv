package com.example.domain.etablissement;

import com.example.domain.Etablissement;

public class Localisation extends Etablissement {
	private Long id;
	private String region;
	private String lib_region;
	private String departement;
	private String arrondissement;
	private String canton;
	private String commune;
	private String lib_commune;
	private String departmeent_unite_urbaine;
	private String taille_unite_urbaine;
	private String num_unite_urbaine;
	private String epci;
	private String tcd;
	private String zemet;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLib_region() {
		return lib_region;
	}
	public void setLib_region(String lib_region) {
		this.lib_region = lib_region;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getArrondissement() {
		return arrondissement;
	}
	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}
	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getLib_commune() {
		return lib_commune;
	}
	public void setLib_commune(String lib_commune) {
		this.lib_commune = lib_commune;
	}
	public String getDepartmeent_unite_urbaine() {
		return departmeent_unite_urbaine;
	}
	public void setDepartmeent_unite_urbaine(String departmeent_unite_urbaine) {
		this.departmeent_unite_urbaine = departmeent_unite_urbaine;
	}
	public String getTaille_unite_urbaine() {
		return taille_unite_urbaine;
	}
	public void setTaille_unite_urbaine(String taille_unite_urbaine) {
		this.taille_unite_urbaine = taille_unite_urbaine;
	}
	public String getNum_unite_urbaine() {
		return num_unite_urbaine;
	}
	public void setNum_unite_urbaine(String num_unite_urbaine) {
		this.num_unite_urbaine = num_unite_urbaine;
	}
	public String getEpci() {
		return epci;
	}
	public void setEpci(String epci) {
		this.epci = epci;
	}
	public String getTcd() {
		return tcd;
	}
	public void setTcd(String tcd) {
		this.tcd = tcd;
	}
	public String getZemet() {
		return zemet;
	}
	public void setZemet(String zemet) {
		this.zemet = zemet;
	}
	
}
