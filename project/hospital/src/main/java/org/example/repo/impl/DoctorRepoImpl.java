package org.example.repo.impl;

import org.example.entity.Doctor;
import org.example.entity.Patient;
import org.example.repo.DoctorRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class DoctorRepoImpl implements DoctorRepo {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Doctor doctor) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(doctor);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Doctor> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Doctor ";
        List<Doctor> doctors = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return doctors;
    }

    @Override
    public Doctor getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Doctor doctor = session.get(Doctor.class, id);
        transaction.commit();
        session.close();
        return doctor;
    }

    @Override
    public Doctor update(Doctor doctor) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(doctor);
        transaction.commit();
        session.close();
        return doctor;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Doctor doctor = session.get(Doctor.class, id);
        session.remove(doctor);
        transaction.commit();
        session.close();
    }
}
