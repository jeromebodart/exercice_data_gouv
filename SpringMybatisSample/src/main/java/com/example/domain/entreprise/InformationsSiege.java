package com.example.domain.entreprise;


public class InformationsSiege {
	private Long id;
	 private String nic;
	 private String code_region;
	 private String departement_commune;
	 private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
