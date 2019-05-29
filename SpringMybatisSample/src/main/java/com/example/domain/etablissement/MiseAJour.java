package com.example.domain.etablissement;

import com.example.domain.Etablissement;

public class MiseAJour extends Etablissement {
	private Long id;
	private String date;
	private boolean modification_activite_etablissement;
	private boolean modification_nature_etablissement;
	private boolean modification_entreprise;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isModification_activite_etablissement() {
		return modification_activite_etablissement;
	}
	public void setModification_activite_etablissement(boolean modification_activite_etablissement) {
		this.modification_activite_etablissement = modification_activite_etablissement;
	}
	public boolean isModification_nature_etablissement() {
		return modification_nature_etablissement;
	}
	public void setModification_nature_etablissement(boolean modification_nature_etablissement) {
		this.modification_nature_etablissement = modification_nature_etablissement;
	}
	public boolean isModification_entreprise() {
		return modification_entreprise;
	}
	public void setModification_entreprise(boolean modification_entreprise) {
		this.modification_entreprise = modification_entreprise;
	}
	
}
