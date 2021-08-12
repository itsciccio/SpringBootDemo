package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Person {

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Address> addresses = new ArrayList<>();

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    public void insertAddress(Address address){
        addresses.add(address);
    }


}
