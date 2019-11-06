package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password" , nullable = false)
	private String password;
	
	@Column(name = "lastname" , nullable = false)
	private String lastname;
	
	@Column(name = "firstname" , nullable = false)
	private String firstname;
	
	@Column(name = "email" , nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Appointment> appointment = new HashSet<Appointment>();
	
	@OneToOne(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Appointment> getAppointment() {
		return oldAppointment;
	}

	public void setOldAppointment(Set<Appointment> Appointment) {
		this.oldAppointment = oldAppointment;
	}

	public Set<Appointment> getCurrentAppointment() {
		return currentAppointment;
	}

	public void setCurrentAppointment(Set<Appointment> currentAppointment) {
		this.currentAppointment = currentAppointment;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	
		
	
}
