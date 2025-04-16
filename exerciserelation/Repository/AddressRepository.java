package com.example.exerciserelation.Repository;

import com.example.exerciserelation.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressesById(Integer id);
}
