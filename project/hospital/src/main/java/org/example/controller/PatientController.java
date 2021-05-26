package org.example.controller;

import org.example.entity.Patient;
import org.example.repo.PatientRepo;
import org.example.repo.impl.PatientRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class PatientController {
    private PatientRepo patientRepo = new PatientRepoImpl();

    public Patient getPatientById(Long id) throws SQLException {
        return patientRepo.getById(id);
    }

    public Patient editPatient(Patient patient) throws SQLException {
        return patientRepo.update(patient);
    }

    public List<Patient> getAllPatients() throws SQLException {
        return patientRepo.getAll();
    }

    public void savePatient(Patient patient) throws SQLException {
        patientRepo.add(patient);
    }

    public void deletePatient(Long id) throws SQLException {
        patientRepo.remove(id);
    }
}
