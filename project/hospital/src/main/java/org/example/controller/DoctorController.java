package org.example.controller;

import org.example.entity.Doctor;
import org.example.entity.Patient;
import org.example.repo.DoctorRepo;
import org.example.repo.impl.DoctorRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class DoctorController {
   private DoctorRepo doctorRepo = new DoctorRepoImpl();

    public Doctor getDoctorById(Long id) throws SQLException {
        return doctorRepo.getById(id);
    }

    public Doctor editDoctor(Doctor doctor) throws SQLException {
        return doctorRepo.update(doctor);
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        return doctorRepo.getAll();
    }

    public void saveDoctor(Doctor doctor) throws SQLException {
        doctorRepo.add(doctor);
    }

    public void deleteDoctor(Long id) throws SQLException {
        doctorRepo.remove(id);
    }

}
