package org.example.repo;

import org.example.entity.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientRepo {
    //create
    void add(Patient patient) throws SQLException;

    //read
    List<Patient> getAll() throws SQLException;

    Patient getById(Long id) throws SQLException;

    //update
    Patient update(Patient patient) throws SQLException;

    //delete
    void remove(Long id) throws SQLException;
}
