package com.example.domain.entreprise;

public class Entreprise {
	private String siren;
	private InformationsSiege Siege;
	private IdentificationEntreprise identification_entreprise;
	private CaracteristiquesEconomiquesEntreprise cracteristiques_economiques;
	
	public Entreprise() {
		super();
	}
	public Entreprise(String siren, InformationsSiege siege, IdentificationEntreprise identification_entreprise, CaracteristiquesEconomiquesEntreprise cracteristiques_economiques) {
		super();
		this.siren = siren;
		Siege = siege;
		this.identification_entreprise = identification_entreprise;
		this.cracteristiques_economiques = cracteristiques_economiques;
	}
	public String getSiren() {
		return siren;
	}
	public void setSiren(String siren) {
		this.siren = siren;
	}
	public InformationsSiege getSiege() {
		return Siege;
	}
	public void setSiege(InformationsSiege siege) {
		Siege = siege;
	}
	public IdentificationEntreprise getIdentification_entreprise() {
		return identification_entreprise;
	}
	public void setIdentification_entreprise(IdentificationEntreprise identification_entreprise) {
		this.identification_entreprise = identification_entreprise;
	}
	public CaracteristiquesEconomiquesEntreprise getCracteristiques_economiques() {
		return cracteristiques_economiques;
	}
	public void setCracteristiques_economiques(CaracteristiquesEconomiquesEntreprise cracteristiques_economiques) {
		this.cracteristiques_economiques = cracteristiques_economiques;
	}
	
}
