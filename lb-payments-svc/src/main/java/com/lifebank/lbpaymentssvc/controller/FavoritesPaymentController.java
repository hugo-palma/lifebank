package com.lifebank.lbpaymentssvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${request-mapping.lb-payments-svc.favorites}")
public class FavoritesPaymentController {
    @PostMapping("${request-mapping.transfer}")
    public ResponseEntity transferFavorite(){
        return new ResponseEntity("transferencia a favorito", HttpStatus.OK);
    }
}
