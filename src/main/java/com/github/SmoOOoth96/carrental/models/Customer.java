package com.github.SmoOOoth96.carrental.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
    private List<Rent> rents;
}
