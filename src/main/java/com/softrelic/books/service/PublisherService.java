package com.softrelic.books.service;

import com.softrelic.books.domain.Address;
import com.softrelic.books.domain.Publisher;
import com.softrelic.books.dtos.PublisherDTO;
import com.softrelic.books.repositories.AddressRepository;
import com.softrelic.books.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    PublisherService(PublisherRepository publisherRepository, AddressRepository addressRepository){
       this.publisherRepository = publisherRepository;
       this.addressRepository = addressRepository;
    }
   public Publisher create(PublisherDTO publisherDTO){
        // Address does not have any foreign key so we save address first.
       // Saved addresss is used in the publisher to create a foreign key relationship
       Address address = new Address();
       address.setStreet(publisherDTO.getAddress().getStreet());
       address.setCity(publisherDTO.getAddress().getCity());
       address.setState(publisherDTO.getAddress().getState());
       address.setZipCode(publisherDTO.getAddress().getZipCode());
       address.setCountry(publisherDTO.getAddress().getCountry());
       Address savedAddress = addressRepository.save(address);

       Publisher publisher = new Publisher();
       publisher.setName(publisherDTO.getName());
       publisher.setEmail(publisherDTO.getEmail());
       publisher.setContact(publisherDTO.getContact());
       publisher.setAddress(savedAddress);

       Publisher savedPublisher = publisherRepository.save(publisher);
       return savedPublisher;
   }
}
