package com.ciccio.ordersservice.config;

import com.ciccio.ordersservice.dao.PersonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableFeignClients(clients = { PersonClient.class } )
public class FeignConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
