package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.annotations.TimeZoneStorage;

import java.util.Date;


// user
//|id |created_date|user_address_country|user_address_city|user_address_street|user_address_home|
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue
    public Integer id;
    @Embedded
    public Address address;
    @Column(name="created_date")
    @Temporal(value = TemporalType.DATE)
    @TimeZoneStorage
    @TimeZoneColumn
    public Date createdDate;
}
