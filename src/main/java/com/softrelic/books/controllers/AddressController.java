package com.softrelic.books.controllers;

import com.softrelic.books.domain.Address;
import com.softrelic.books.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

}
