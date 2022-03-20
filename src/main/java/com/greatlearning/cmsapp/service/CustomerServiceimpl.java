package com.greatlearning.cmsapp.service;

import com.greatlearning.cmsapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerServiceimpl implements CustomerService {

    private SessionFactory sessionFactory;
    private Session session;

    public Customer findById(int id) {
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);

        tx.commit();
        return customer;
    }
    public CustomerServiceimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }

    public void save(Customer customer) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(customer);
        tx.commit();
    }
    public List<Customer> findAll() {

        Transaction tx = session.beginTransaction();

        List<Customer> customers = session.createQuery("from Customer",Customer.class).list();
        tx.commit();
        return customers;
    }

    public void deleteById(int id) {
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
        } finally {
            tx.commit();
        }

    }
}
