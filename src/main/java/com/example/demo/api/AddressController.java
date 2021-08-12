package com.example.demo.api;

import com.example.demo.api.dto.AddressDTO;
import com.example.demo.api.dto.PersonDTO;
import com.example.demo.api.dto.UpdateAddressRequestDTO;
import com.example.demo.service.AddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api
@RequestMapping("/address")
@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDTO> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @DeleteMapping("/{aID}")
    public void removeAddressByID(@PathVariable("aID") UUID addressID){
        addressService.removeAddressById(addressID);
    }

    @PutMapping("/{aID}")
    public void updatePersonAddressByID(@PathVariable("aID") UUID addressID, @RequestBody UpdateAddressRequestDTO updateAddressRequestDTO){
        addressService.updateAddressById(addressID, updateAddressRequestDTO);
    }

    @GetMapping("/{cityCode}")
    public List<AddressDTO> getAllAddressesWithCityCode(@PathVariable("cityCode") String cityCode){
        return addressService.getAllAddressesWithinCityCode(cityCode);
    }
}
