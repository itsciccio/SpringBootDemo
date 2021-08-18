package com.example.demo.dao;

import com.example.demo.api.dto.UpdatePersonRequestDTO;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
//        DB.add(new Person(id,person.getName(), person.getAge()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public void removePersonById(UUID personID) {
        DB.removeIf(person -> person.getId().equals(personID));
    }

    public void updatePersonById(UUID personID,  UpdatePersonRequestDTO updatePersonRequestDTO){
        Person p = DB
                .stream()
                .filter(person -> person.getId().equals(personID))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Person does not exist."));
        if(updatePersonRequestDTO.getName() != null){
            p.setName(updatePersonRequestDTO.getName());
        }
        if(updatePersonRequestDTO.getAge() != -1){
            p.setAge(updatePersonRequestDTO.getAge());
        }
    }

}
