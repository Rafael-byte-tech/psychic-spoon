package com.address.myaddressbootapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Address address;
}