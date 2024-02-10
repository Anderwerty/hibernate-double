package org.example;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerHibernateDao;
import org.example.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        CustomerDao customerDao = new CustomerHibernateDao(sessionFactory);
        List<Customer> customers = customerDao.findAll();

        for (Customer customer : customers) {
            System.out.println(customer);
        }


        System.out.println("===============================");

        System.out.println(customerDao.findById(10).orElse(null));
        System.out.println("===============================");

        Customer customer = new Customer();
        customer.setId(112);
        customer.setCustomerName("Alex");
        customer.setSex("male");
        customer.setEmail("email@gmail.com");
        customer.setTelephone(1234);
       customer.setAddress("Address");

        customerDao.save(customer);
        System.out.println("==============================");

        List<Customer> customers2 = customerDao.findAll();

        for (Customer c : customers2) {
            System.out.println(c);
        }
        System.out.println("============================");
        customerDao.delete(customer);
        System.out.println("=======================");
        List<Customer> customers3 = customerDao.findAll();

        for (Customer c : customers3) {
            System.out.println(c);
        }
    }
}

//Hibernate: select c1_0.id,c1_0.address,c1_0.name,c1_0.email,c1_0.sex,c1_0.telephone from customers c1_0
