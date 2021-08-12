package com.example.demo.utils;

import com.example.demo.api.dto.PersonDTO;
import com.example.demo.model.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.ClassMapBuilderFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ModelMapper extends ConfigurableMapper {
    @Getter
    private MapperFactory mapperFactory;

    public void configure(MapperFactory factory) {
        super.configure(factory);
        this.mapperFactory = factory;

        factory.registerClassMap(factory.classMap(Person.class, PersonDTO.class)
                .customize(new CustomMapper<Person, PersonDTO>() {
                    @Override
                    public void mapAtoB(Person source, PersonDTO destination, MappingContext context) {
//                        destination.setId(UUID.fromString(source.getId()));
                    }
                }).byDefault().toClassMap());

    }

}