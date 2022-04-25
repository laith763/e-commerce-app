package com.example.assignmentone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AssignmentOneApplication {

    @Bean
    public org.modelmapper.ModelMapper modelMapper(){
        return new org.modelmapper.ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(AssignmentOneApplication.class, args);
    }

}
