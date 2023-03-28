package com.example.postgres.DAO;
import com.example.postgres.City;
import com.example.postgres.Employee;
import com.example.postgres.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public EmployeeDAOImpl() {

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
    public Employee getById(Integer id)  {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> users = (List<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return users;
    }

    @Override
    public void updateEmployeeById(Integer id, String first_name, String last_name, String gender, int age, City city) {
        Employee employee = new Employee(id, first_name, last_name, gender, age, city);
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