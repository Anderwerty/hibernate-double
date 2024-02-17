package org.example.dao;

import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

//CRUD
public class CustomerHibernateDao implements CustomerDao {
    private final SessionFactory sessionFactory;

    public CustomerHibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            // SQL: SELECT * FROM customers;
            // HQL: FROM Client
            // where Client - entity name, look at annotation @Entity on class Customer
            Query<Customer> customerQuery = session.createQuery("FROM Client", Customer.class);
            return customerQuery.list();
        }
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, id);

            return Optional.ofNullable(customer);
        }
    }

    @Override
    public Optional<Customer> findById2(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.load(Customer.class, id);

            System.out.println("***************************");
            System.out.println(customer.getCustomerName());
            System.out.println("***************************");
            return Optional.ofNullable(customer);
        }
    }

    public List<Customer> findByName(String name, int limit, int offset) {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("from Client where customerName = :name", Customer.class);

            query.setParameter("name", name);
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            return query.getResultList();
        }
    }

    @Override
    public void save(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void save2(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.load(Customer.class, id);
            session.evict(customer);
            session.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
//                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Customer customer) {
        //TODO: not full implementation
        try (Session session = sessionFactory.openSession()) {
            session.remove(customer);
        }
    }
}
