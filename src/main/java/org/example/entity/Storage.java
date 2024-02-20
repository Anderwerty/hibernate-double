package org.example.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "storages")
public class Storage {
    @Id
    private Integer id;

    //...

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name ="storage-country")),
            @AttributeOverride(name = "country", column = @Column(name ="storage-country")),
            //....
    })
    public Address address;
}
