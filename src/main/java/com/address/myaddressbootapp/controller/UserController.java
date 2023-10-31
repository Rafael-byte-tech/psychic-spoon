package com.address.myaddressbootapp.controller;

import com.address.myaddressbootapp.dto.AddressDTO;
import com.address.myaddressbootapp.dto.UserDTO;
import com.address.myaddressbootapp.exception.NotFoundException;
import com.address.myaddressbootapp.model.Address;
import com.address.myaddressbootapp.model.User;
import com.address.myaddressbootapp.service.AddressService;
import com.address.myaddressbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController
{
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;

    @PostMapping("post")
    public User post(@RequestBody UserDTO userDTO, @RequestBody AddressDTO addressDTO)
    {
        return userService.create(userDTO, addressService.create(addressDTO));
    }

    @GetMapping("get/{id}")
    public User get(@PathVariable int id)
    {
        try
        {
            return userService.retrieve(id);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }

        return null;
    }
}