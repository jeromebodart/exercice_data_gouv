package com.example.domain.entreprise;

public class Entreprise {
	private Long id;
	private Long siren;
	private InformationsSiege siege;
	private IdentificationEntreprise identification_entreprise;
	private CaracteristiquesEconomiquesEntreprise caracteristiques_economiques;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSiren() {
		return siren;
	}
	public void setSiren(Long siren) {
		this.siren = siren;
	}
	public InformationsSiege getSiege() {
		return siege;
	}
	public void setSiege(InformationsSiege psiege) {
		siege = psiege;
	}
	public IdentificationEntreprise getIdentification_entreprise() {
		return identification_entreprise;
	}
	public void setIdentification_entreprise(IdentificationEntreprise identification_entreprise) {
		this.identification_entreprise = identification_entreprise;
	}
	public CaracteristiquesEconomiquesEntreprise getCaracteristiques_economiques() {
		return caracteristiques_economiques;
	}
	public void setCaracteristiques_economiques(CaracteristiquesEconomiquesEntreprise caracteristiques_economiques) {
		this.caracteristiques_economiques = caracteristiques_economiques;
	}
	
}
