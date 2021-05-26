package org.example.repo.impl;

import org.example.entity.Patient;
import org.example.repo.PatientRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class PatientRepoImpl implements PatientRepo {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Patient patient) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(patient);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Patient> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Patient ";
        List<Patient> clients = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return clients;
    }

    @Override
    public Patient getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Patient patient = session.get(Patient.class, id);
        transaction.commit();
        session.close();
        return patient;
    }

    @Override
    public Patient update(Patient patient) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(patient);
        transaction.commit();
        session.close();
        return patient;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Patient patient = session.get(Patient.class, id);
        session.remove(patient);
        transaction.commit();
        session.close();
    }
}
