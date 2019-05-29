package com.example.domain.etablissement;

import com.example.domain.Etablissement;

public class Informations extends Etablissement {
	private Long id;
	private String enseigne;
	private boolean ind_publipo;
	private boolean siege;
	private boolean statut;
	private String date_diffusion_base;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnseigne() {
		return enseigne;
	}
	public void setEnseigne(String enseigne) {
		this.enseigne = enseigne;
	}
	public boolean isInd_publipo() {
		return ind_publipo;
	}
	public void setInd_publipo(boolean ind_publipo) {
		this.ind_publipo = ind_publipo;
	}
	public boolean isSiege() {
		return siege;
	}
	public void setSiege(boolean siege) {
		this.siege = siege;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public String getDate_diffusion_base() {
		return date_diffusion_base;
	}
	public void setDate_diffusion_base(String date_diffusion_base) {
		this.date_diffusion_base = date_diffusion_base;
	}
	
}
