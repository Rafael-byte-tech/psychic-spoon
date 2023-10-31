package com.address.myaddressbootapp.dto;

import lombok.Data;

@Data
public class AddressDTO
{
    private String thoroughfare;
    private String neighbourhood;
    private String city;
    private String state;
    private String number;
}
