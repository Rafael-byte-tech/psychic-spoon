package com.address.myaddressbootapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String thoroughfare;
    private String neighbourhood;
    private String city;
    private String state;
    private String number;
}