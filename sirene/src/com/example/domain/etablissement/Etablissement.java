package com.example.domain.etablissement;

import com.example.domain.entreprise.Entreprise;

public class Etablissement extends Entreprise {
	private String SIRET;
	private Entreprise entreprise;
	private String nic;
	private AdresseDeclaree adressedeclaree;
	private AdresseNormalisee adresse_normalisee;
	private Informations info;
	private AdresseGeographique adressegeographique;
	private Localisation localisation;
	private CaracteristiquesEconomiquesEtablissement economies;
	private MiseAJour mises_a_jour;
	
	public Etablissement() {
		super();
	}
	public Etablissement(String sIRET, Entreprise entreprise, String nic, AdresseDeclaree adressedeclaree, AdresseNormalisee adresse_normalisee, Informations info, AdresseGeographique adressegeographique, Localisation localisation, CaracteristiquesEconomiquesEtablissement economies, MiseAJour mises_a_jour) {
		super();
		SIRET = sIRET;
		this.entreprise = entreprise;
		this.nic = nic;
		this.adressedeclaree = adressedeclaree;
		this.adresse_normalisee = adresse_normalisee;
		this.info = info;
		this.adressegeographique = adressegeographique;
		this.localisation = localisation;
		this.economies = economies;
		this.mises_a_jour = mises_a_jour;
	}
	public String getSIRET() {
		return SIRET;
	}
	public void setSIRET(String sIRET) {
		SIRET = sIRET;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public AdresseDeclaree getAdressedeclaree() {
		return adressedeclaree;
	}
	public void setAdressedeclaree(AdresseDeclaree adressedeclaree) {
		this.adressedeclaree = adressedeclaree;
	}
	public AdresseNormalisee getAdresse_normalisee() {
		return adresse_normalisee;
	}
	public void setAdresse_normalisee(AdresseNormalisee adresse_normalisee) {
		this.adresse_normalisee = adresse_normalisee;
	}
	public Informations getInfo() {
		return info;
	}
	public void setInfo(Informations info) {
		this.info = info;
	}
	public AdresseGeographique getAdressegeographique() {
		return adressegeographique;
	}
	public void setAdressegeographique(AdresseGeographique adressegeographique) {
		this.adressegeographique = adressegeographique;
	}
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	public CaracteristiquesEconomiquesEtablissement getEconomies() {
		return economies;
	}
	public void setEconomies(CaracteristiquesEconomiquesEtablissement economies) {
		this.economies = economies;
	}
	public MiseAJour getMises_a_jour() {
		return mises_a_jour;
	}
	public void setMises_a_jour(MiseAJour mises_a_jour) {
		this.mises_a_jour = mises_a_jour;
	}
}
