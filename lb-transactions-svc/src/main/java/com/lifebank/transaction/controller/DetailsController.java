package com.lifebank.transaction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${request-mapping.transactions-svc}")
public class DetailsController {
    @GetMapping("${request-mapping.details}")
    public ResponseEntity getProductDetails(){
        return new ResponseEntity<String>("hola Mundo", HttpStatus.OK);
    }
}
