package com.lifebank.lbpaymentssvc.validator;

import com.lifebank.lbpaymentssvc.pojo.request.IPaymentRequest;
import com.lifebank.lbpaymentssvc.pojo.request.RequestBlueprint;
import org.springframework.http.ResponseEntity;

public interface IValidator {
    public ResponseEntity validateParameters(RequestBlueprint paymentRequest, Integer clientId);
}
