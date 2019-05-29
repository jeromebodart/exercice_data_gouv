package com.example.domain.etablissement;

import com.example.domain.Etablissement;

public class AdresseGeographique extends Etablissement {
	private Long id;

	private String numvoie;
	private String indrep;
	private String typvoie;
	private String lib_voie;
	private String codpos;
	private String cedex;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumvoie() {
		return numvoie;
	}
	public void setNumvoie(String numvoie) {
		this.numvoie = numvoie;
	}
	public String getIndrep() {
		return indrep;
	}
	public void setIndrep(String indrep) {
		this.indrep = indrep;
	}
	public String getTypvoie() {
		return typvoie;
	}
	public void setTypvoie(String typvoie) {
		this.typvoie = typvoie;
	}
	public String getLib_voie() {
		return lib_voie;
	}
	public void setLib_voie(String lib_voie) {
		this.lib_voie = lib_voie;
	}
	public String getCodpos() {
		return codpos;
	}
	public void setCodpos(String codpos) {
		this.codpos = codpos;
	}
	public String getCedex() {
		return cedex;
	}
	public void setCedex(String cedex) {
		this.cedex = cedex;
	}
	
}
