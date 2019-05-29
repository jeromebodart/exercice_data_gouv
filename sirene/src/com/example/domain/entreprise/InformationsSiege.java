package com.example.domain.entreprise;


public class InformationsSiege extends Entreprise {
	 private String nic;
	 private String code_region;
	 private String departement_commune;
	 private String email;
	 
	
	public InformationsSiege(String nic, String code_region, String departement_commune, String email) {
		super();
		this.nic = nic;
		this.code_region = code_region;
		this.departement_commune = departement_commune;
		this.email = email;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getCode_region() {
		return code_region;
	}

	public void setCode_region(String code_region) {
		this.code_region = code_region;
	}

	public String getDepartement_commune() {
		return departement_commune;
	}

	public void setDepartement_commune(String departement_commune) {
		this.departement_commune = departement_commune;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	 
}
