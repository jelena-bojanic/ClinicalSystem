package com.example.ClinicalSystem.controller;

import com.example.ClinicalSystem.DTO.AppointmentDTO;
import com.example.ClinicalSystem.DTO.DoctorDTO;
import com.example.ClinicalSystem.model.Appointment;
import com.example.ClinicalSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(method = RequestMethod.GET, value = "/allpredefined")
    @PreAuthorize("hasAnyAuthority('CLINICADMIN','PATIENT')")
    public ResponseEntity<List<AppointmentDTO>> getAll() {

        List<AppointmentDTO> predefined = appointmentService.findAllPredefined();

        return new ResponseEntity<>(predefined, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savepredefined")
    @PreAuthorize("hasAuthority('CLINICADMIN')")
    public ResponseEntity<AppointmentDTO> savePredefiend(@RequestBody AppointmentDTO appointmentDTO) {

        if(appointmentService.savePredefined(appointmentDTO))
            return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);

        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}