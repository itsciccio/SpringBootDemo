package com.ciccio.ordersservice.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMapper extends ConfigurableMapper {
    @Getter
    private MapperFactory mapperFactory;

    public void configure(MapperFactory factory) {
        super.configure(factory);
        this.mapperFactory = factory;

    }

}