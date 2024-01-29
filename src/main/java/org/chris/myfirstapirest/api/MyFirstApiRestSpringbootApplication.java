package org.chris.myfirstapirest.api;

import org.chris.myfirstapirest.api.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyFirstApiRestSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstApiRestSpringbootApplication.class, args);
    }

    @Bean
    public UserMapper userMapper(){
        return Mappers.getMapper(UserMapper.class);
    }

}
