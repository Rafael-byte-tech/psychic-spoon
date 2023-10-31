package com.address.myaddressbootapp.service;

import com.address.myaddressbootapp.dto.AddressDTO;
import com.address.myaddressbootapp.exception.NotFoundException;
import com.address.myaddressbootapp.model.Address;
import com.address.myaddressbootapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class AddressService
{
    @Autowired
    public AddressRepository repository;

    public Address create(AddressDTO dto)
    {
        Address address;

        address = new Address();

        address.setThoroughfare(dto.getThoroughfare());
        address.setNeighbourhood(dto.getNeighbourhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setNumber(dto.getNumber());

        return this.repository.save(address);
    }

    public Address retrieve(int id) throws NotFoundException
    {
        Optional<Address> entity;

        entity = this.repository.findById(id);

        if (entity.isPresent()) return entity.get();
        else throw new NotFoundException("Endereço não encontrado.");
    }

    public List<Address> retrieveAll()
    {
        return repository.findAll();
    }

    public Address update(int id, AddressDTO dto)
    {
        Address address;

        try
        {
            address = retrieve(id);

            address.setThoroughfare(dto.getThoroughfare());
            address.setNeighbourhood(dto.getNeighbourhood());
            address.setCity(dto.getCity());
            address.setState(dto.getState());
            address.setNumber(dto.getNumber());

            return address;
        }
        catch (NotFoundException e)
        {
            e.getMessage();
        }
        return null;
    }

    public void delete(int id)
    {
        repository.deleteById(id);
    }
}