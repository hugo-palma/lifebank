package com.lifebank.lbpaymentssvc.authorization;

import com.lifebank.lbpaymentssvc.pojo.LbAuthorizationRegistryPOJO;
import com.lifebank.lbpaymentssvc.repository.AuthorizationRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AuthorizationBean {
    private AuthorizationRegistryRepository authorizationRegistryRepository;

    @Autowired
    public AuthorizationBean(AuthorizationRegistryRepository authorizationRegistryRepository){
        this.authorizationRegistryRepository = authorizationRegistryRepository;
    }

    public Integer getAuthorizationNumber(Integer clientId, String ip){
        LbAuthorizationRegistryPOJO lbAuthorizationRegistryPOJO = new LbAuthorizationRegistryPOJO();
        lbAuthorizationRegistryPOJO.setAreClientId(clientId.toString());
        lbAuthorizationRegistryPOJO.setAreClientIp(ip);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        lbAuthorizationRegistryPOJO.setAreCreationDate(timestamp);
        lbAuthorizationRegistryPOJO = authorizationRegistryRepository.save(lbAuthorizationRegistryPOJO);
        return lbAuthorizationRegistryPOJO.getAreId();
    }
}
