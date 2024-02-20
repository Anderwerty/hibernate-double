package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name="user_address_country")
    public String country;
    @Column(name="user_address_city")
    public String city;
    @Column(name="user_address_street")
    public String street;
    @Column(name="user_address_home")
    public String home;
}
