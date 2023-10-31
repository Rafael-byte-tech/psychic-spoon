package com.address.myaddressbootapp.service;

import com.address.myaddressbootapp.dto.UserDTO;
import com.address.myaddressbootapp.exception.NotFoundException;
import com.address.myaddressbootapp.model.Address;
import com.address.myaddressbootapp.model.User;
import com.address.myaddressbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserService
{
    @Autowired
    public UserRepository repository;

    public User create(UserDTO dto, Address address)
    {
        User user;

        user = new User();

        user.setName(dto.getName());
        user.setBirthdate(dto.getBirthdate());
        user.setAddress(address);

        return this.repository.save(user);
    }

    public User retrieve(int id) throws NotFoundException
    {
        Optional<User> entity;

        entity = this.repository.findById(id);

        if(entity.isPresent()) return entity.get();
        else throw new NotFoundException("Entidade não encontrada.");
    }

    public List<User> retrieveAll()
    {
        return this.repository.findAll();
    }

    public User update(int id, UserDTO dto, Address address)
    {
        User user;

        try
        {
            user = retrieve(id);

            user.setName(dto.getName());
            user.setBirthdate(dto.getBirthdate());
            user.setAddress(address);

            return this.repository.save(user);
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }

        return null;
    }

    public void delete(int id)
    {
        this.repository.deleteById(id);
    }
}