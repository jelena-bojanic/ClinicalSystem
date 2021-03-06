package com.example.ClinicalSystem.DTO;

import com.example.ClinicalSystem.model.ClinicAdmin;
import com.example.ClinicalSystem.model.Clinic;
import com.example.ClinicalSystem.model.Role;

public class ClinicAdminDTO {

	private Long id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private ClinicDTO clinic;
	private String clinicName;
	private Role role = Role.CLINICADMIN;
	private boolean firstLogin;
	private double clinicRating;

	public ClinicAdminDTO() {
		super();
	}
	public ClinicAdminDTO(Long id, String firstName, String lastName, String email, String password, ClinicDTO clinic,Role role, boolean firstLogin) {

		super();
		this.id = id;
		this.name = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
		this.clinic = clinic;
		this.role=role;
		this.firstLogin = firstLogin;
	}

	public ClinicAdminDTO(ClinicAdmin clinicAdmin){
		this.id = clinicAdmin.getId();
		this.name = clinicAdmin.getName();
		this.lastname = clinicAdmin.getLastname();
		this.email = clinicAdmin.getEmail();
		this.password = clinicAdmin.getPassword();
		this.clinicName = clinicAdmin.getClinic().getName();
		this.role = clinicAdmin.getRole();
		this.firstLogin = clinicAdmin.isFirstlogin();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String firstName) {
		this.name = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClinicDTO getClinic() { return clinic; }

	public void setClinic(ClinicDTO clinic) { this.clinic = clinic; }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public double getClinicRating() {
		return clinicRating;
	}

	public void setClinicRating(double clinicRating) {
		this.clinicRating = clinicRating;
	}
}
