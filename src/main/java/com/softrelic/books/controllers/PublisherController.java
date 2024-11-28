package com.softrelic.books.controllers;

import com.softrelic.books.domain.Publisher;
import com.softrelic.books.dtos.PublisherDTO;
import com.softrelic.books.repositories.AddressRepository;
import com.softrelic.books.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

   @Autowired
   private PublisherService publisherService;
   @PostMapping()
   public Publisher create(@RequestBody PublisherDTO publisherDTO){
      return publisherService.create(publisherDTO);
   }
}
