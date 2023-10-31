package com.address.myaddressbootapp.dto;

import com.address.myaddressbootapp.model.Address;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO
{
    private String name;
    private LocalDate birthdate;
}