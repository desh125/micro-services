package com.example.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/customer")
@EnableDiscoveryClient
public class CustomerController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/getCustomer")
    public String getCustomer(){
        return restTemplate.getForObject("http://ITEM-SERVICE/api/v1/item/getItem",String.class);
    }
    @PostMapping("/saveCustomer")
    public Object SaveCustomer(@RequestBody Object customer){
        System.out.println(customer);
        return restTemplate.postForObject("http://ITEM-SERVICE/api/v1/item/saveItem",customer,Object.class);
    }
}
