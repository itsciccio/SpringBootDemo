package com.example.demo.service;

import com.example.demo.api.dto.*;
import com.example.demo.dao.AddressRepository;
import com.example.demo.dao.CityRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Address;
import com.example.demo.model.City;
import com.example.demo.model.Person;
import com.example.demo.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    final UserRepository userRepository;

    @Autowired
    final CityRepository cityRepository;

    @Autowired
    final AddressRepository addressRepository;

    private final ModelMapper mapper;

    public void createPerson(CreatePersonRequestDTO createPersonRequestDTO){
        Person person = new Person();
        person.setName(createPersonRequestDTO.getName());
//        person.setId(UUID.randomUUID().toString().replace("-",""));
        person.setAge(createPersonRequestDTO.getAge());

        if(createPersonRequestDTO.getAddresses()!=null){
            for (CreateAddressDTO addressDto : createPersonRequestDTO.getAddresses())
            {
                Address address = new Address();
                address.setHouseNumber(addressDto.getHouseNumber());
                address.setStreet(addressDto.getStreet());


                City city = cityRepository.findById(addressDto.getCity())
                        .orElseThrow(() -> new EntityNotFoundException("City not found: "+ addressDto.getCity()));

                address.setCity(city);

                person.insertAddress(address);
            }
        }
        userRepository.save(person);
    }

    public List<PersonDTO> getAllPeople(){
        return userRepository.findAll().stream()
                .map(person -> mapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());
    }

    public PersonDTO findPersonById(UUID personId){
        Person foundPerson = userRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: "+personId));
        return mapper.map(foundPerson, PersonDTO.class);
    }


    public void removePersonById(UUID personId){
        Person personToRemove = mapper.map(findPersonById(personId),Person.class);
        userRepository.delete(personToRemove);
    }

    public void updatePersonById(UUID personId, UpdatePersonRequestDTO updatePersonRequestDTO){
        Person personToUpdate = userRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: "+personId));
        if(updatePersonRequestDTO.getName() != null){
            personToUpdate.setName(updatePersonRequestDTO.getName());
        }
        if(updatePersonRequestDTO.getAge() != -1){
            personToUpdate.setAge(updatePersonRequestDTO.getAge());
        }
        userRepository.save(personToUpdate);
    }


}
