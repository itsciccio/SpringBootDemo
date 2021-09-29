package com.ciccio.ordersservice.dao;

import com.ciccio.ordersservice.api.dto.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "person-client", url="${feign.person-service.url:http://google.com}")
public interface PersonClient {

    @GetMapping("/persons/{personId}")
    PersonDTO getPersonById(@PathVariable final UUID personId);
}
