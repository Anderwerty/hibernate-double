package org.example;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerHibernateDao;
import org.example.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        CustomerHibernateDao customerDao = new CustomerHibernateDao(sessionFactory);

//        Customer customer = customerDao.findById2(10).get();
//        System.out.println(customer == null);
//        System.out.println(customer.getClass());
//        System.out.println(customer.getId());
//        System.out.println(customer.getCustomerName()); // exception here
//        System.out.println(customer);
//        System.out.println("saving");
//        Customer customer1 = new Customer();
//        customer1.setAddress("address_________");
//        customer1.setId(200);
//        customer1.setTelephone(0);
//        customer1.setCustomerName("Customer Name");
//        customer1.setEmail("1@1");
//        customer1.setSex("male");
//
//        customerDao.save(customer1);

        customerDao.save2(200);

    }
}
