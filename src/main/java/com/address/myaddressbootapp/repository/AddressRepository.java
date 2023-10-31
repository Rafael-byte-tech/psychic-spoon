package com.address.myaddressbootapp.repository;

import com.address.myaddressbootapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>
{
}
