package com.example.ClinicalSystem.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.ClinicalSystem.DTO.ClinicAdminDTO;
import com.example.ClinicalSystem.DTO.DoctorDTO;
import com.example.ClinicalSystem.model.Authority;
import com.example.ClinicalSystem.model.ClinicAdmin;
import com.example.ClinicalSystem.model.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClinicalSystem.DTO.ClinicDTO;
import com.example.ClinicalSystem.model.Clinic;
import com.example.ClinicalSystem.repository.ClinicRepository;

import javax.transaction.Transactional;

@Service
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ClinicAdminService clinicAdminService;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private DoctorService doctorService;

	
	public boolean addClinic(Clinic clinic) {

		if(findName(clinic.getName()) != null){
			return false;
		}

		clinicRepo.save(clinic);
		return true;
	}


	public List<Clinic> findAllClinics() {

		List<Clinic> clinics = clinicRepo.findAllByOrderByNameAsc();

		return clinics;
	}


	public  Clinic findClinic(ClinicDTO clinicDTO) {

		if(clinicRepo.findByName(clinicDTO.getName()) != null) {
			Clinic clinic = modelMapper.map(clinicDTO, Clinic.class);
			return clinic;
		}

		return null;
	}

	public Clinic findName(String name) {
		if(clinicRepo.findByName(name) != null) {
			return clinicRepo.findByName(name);
		}

		return null;
	}

	public  Clinic findClinic(Clinic clinic) {

		if(clinicRepo.findByName(clinic.getName()) != null) {
			return clinic;
		}

		return null;
	}

	public Clinic updateClinic(Clinic clinic) {

		return clinicRepo.save(clinic);
	}

	public ClinicDTO findClinic(String name) {
		Clinic clinic = clinicRepo.findByName(name);
		ClinicDTO clinicDTO = modelMapper.map(clinic, ClinicDTO.class);
		return clinicDTO;
	}

	@Transactional
	public boolean addAdminToClinic(ClinicDTO clinicDTO, ClinicAdminDTO cadminDTO){
		Clinic clinic = modelMapper.map(clinicDTO, Clinic.class);
		ClinicAdmin cAdmin = modelMapper.map(cadminDTO, ClinicAdmin.class);

		Authority authoritie = authorityService.findByname("CLINICADMIN");
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authoritie);
		cAdmin.setAuthorities(authorities);


		clinic.getClinicAdmins().add(cAdmin);
		cAdmin.setClinic(clinic);
		clinicRepo.save(clinic);

		if(cAdmin.getClinic() != null){
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public boolean addDoctorsToClinic(ClinicDTO clinicDTO, List<DoctorDTO> doctorDTOS) {
		Clinic clinic = modelMapper.map(clinicDTO, Clinic.class);
		List<Doctor> doctors = new ArrayList<Doctor>();

		for(DoctorDTO ddto : doctorDTOS) {
			Doctor doctor = modelMapper.map(ddto, Doctor.class);
			doctor.setClinic(clinic);
			doctors.add(doctor);
		}

		clinic.setDoctors((Set<Doctor>) doctors);

		return true;
	}

	public boolean connectDoctorWithClinic(String name, DoctorDTO doctorDTO) {

		Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
		Clinic clinic = clinicRepo.findByName(name);

		if(doctor.getClinic() == null){
			clinic.getDoctors().add(doctor);
			clinicRepo.save(clinic);
		}

		return false;
	}
}
