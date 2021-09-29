package com.ciccio.ordersservice.service;

import com.ciccio.ordersservice.api.dto.PersonDTO;
import com.ciccio.ordersservice.dao.PersonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonClient personClient;

    public PersonDTO getPersonById(UUID id){
        try {
            return personClient.getPersonById(id);
        }catch(Exception e){
            return null;
        }
    }

}
