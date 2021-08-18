package com.example.demo.api;

import com.example.demo.api.dto.CreatePersonRequestDTO;
import com.example.demo.api.dto.PersonDTO;
import com.example.demo.api.dto.UpdateAddressRequestDTO;
import com.example.demo.api.dto.UpdatePersonRequestDTO;
import com.example.demo.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api
@RequestMapping("/persons")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void createPerson(@RequestBody CreatePersonRequestDTO createPersonRequestDTO){
        personService.createPerson(createPersonRequestDTO);
    }

    @GetMapping
    public List<PersonDTO> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/{pID}")
    public PersonDTO findPersonByID(@PathVariable("pID") UUID personID){
        return personService.findPersonById(personID);
    }

    @DeleteMapping("/{pID}")
    public void removePersonByID(@PathVariable("pID") UUID personID){
        personService.removePersonById(personID);
    }


    @PutMapping("/{pID}")
    public void updatePersonByID(@PathVariable("pID") UUID personID, @RequestBody UpdatePersonRequestDTO updatePersonRequestDTO){
        personService.updatePersonById(personID, updatePersonRequestDTO);
    }





}
