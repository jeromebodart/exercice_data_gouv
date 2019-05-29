package com.example.domain.etablissement;

public class Informations extends Etablissement {
	private String enseigne;
	private String ind_publipo;
	private String siege_ou_pas;
	private String statut;
	private String date_diffusion_base;
	
	public Informations(String enseigne, String ind_publipo, String siege_ou_pas, String statut, String date_diffusion_base) {
		super();
		this.enseigne = enseigne;
		this.ind_publipo = ind_publipo;
		this.siege_ou_pas = siege_ou_pas;
		this.statut = statut;
		this.date_diffusion_base = date_diffusion_base;
	}
	public String getEnseigne() {
		return enseigne;
	}
	public void setEnseigne(String enseigne) {
		this.enseigne = enseigne;
	}
	
	public String getInd_publipo() {
		return ind_publipo;
	}
	public void setInd_publipo(String ind_publipo) {
		this.ind_publipo = ind_publipo;
	}

	public String getSiege_ou_pas() {
		return siege_ou_pas;
	}
	public void setSiege_ou_pas(String siege_ou_pas) {
		this.siege_ou_pas = siege_ou_pas;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDate_diffusion_base() {
		return date_diffusion_base;
	}
	public void setDate_diffusion_base(String date_diffusion_base) {
		this.date_diffusion_base = date_diffusion_base;
	}
	
}
