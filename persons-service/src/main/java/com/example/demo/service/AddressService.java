package com.example.demo.service;

import com.example.demo.api.dto.AddressDTO;
import com.example.demo.api.dto.UpdateAddressRequestDTO;
import com.example.demo.dao.AddressRepository;
import com.example.demo.dao.CityRepository;
import com.example.demo.model.Address;
import com.example.demo.model.City;
import com.example.demo.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    final AddressRepository addressRepository;

    @Autowired
    final CityRepository cityRepository;

    private final ModelMapper mapper;

    public List<AddressDTO> getAllAddresses(){
        return addressRepository.findAll().stream()
                .map(address -> mapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

    public List<AddressDTO> getAllAddressesWithinCityCode(String cityCode){
        return addressRepository.findAll().stream()
                .filter(city -> Objects.equals(city.getCity().getCode(), cityCode))
                .map(address -> mapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

    public AddressDTO findAddressById(UUID addressId){
        Address foundAddress = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found: "+addressId));
        return mapper.map(foundAddress, AddressDTO.class);
    }

    public void removeAddressById(UUID addressId){
        Address addressToRemove = mapper.map(findAddressById(addressId),Address.class);
        addressRepository.delete(addressToRemove);
    }

    public void updateAddressById(UUID addressId, UpdateAddressRequestDTO updateAddressRequestDTO){
        Address addressToUpdate = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found: "+addressId));
        if(updateAddressRequestDTO.getHouseNumber() != -1){
            addressToUpdate.setHouseNumber(updateAddressRequestDTO.getHouseNumber());
        }
        if(updateAddressRequestDTO.getStreet() != null){
            addressToUpdate.setStreet(updateAddressRequestDTO.getStreet());
        }
        if(updateAddressRequestDTO.getCity() != null){
            City city = cityRepository.findById(updateAddressRequestDTO.getCity())
                    .orElseThrow(() -> new EntityNotFoundException("City not found: "+ updateAddressRequestDTO.getCity()));
            addressToUpdate.setCity(city);
        }
        addressRepository.save(addressToUpdate);
    }





}
