package com.example.postgres.DAO;
import com.example.postgres.Employee;
import com.example.postgres.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;
    public EmployeeDAOImpl() {
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
                Transaction transaction = session.beginTransaction();
                session.save(employee);
                transaction.commit();
            }
        }
    }

    @Override
    public Employee getById(int id)  {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> users = (List<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return users;
    }

    @Override
    public void updateEmployeeById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}