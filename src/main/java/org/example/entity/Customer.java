package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "customers")
@Entity(name ="Client")
@NamedQuery(name ="select_all", query = "")
public class Customer {

//    @Column(name = "id")
    @Id
//    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String customerName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "email")
    private String email;

    @Column
    private int telephone;

//    @Column
    private String address;
}
