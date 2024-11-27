package com.softrelic.books.controllers;

import com.softrelic.books.domain.Publisher;
import com.softrelic.books.repositories.AddressRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
   @PostMapping()
   public Publisher create(){
      return null;
   }
}
