package com.softrelic.books.service;

import com.softrelic.books.domain.Address;
import com.softrelic.books.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address create(Address address){
        return addressRepository.save(address);
    }

}

