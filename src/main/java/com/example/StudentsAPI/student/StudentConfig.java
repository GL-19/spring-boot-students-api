package com.example.StudentsAPI.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            var maria =  new Student(
                    1L,
                    "Maria",
                    "maria@email.com",
                    LocalDate.of(2000, Month.FEBRUARY, 19)
            );

            var peter = new Student(
                    2L,
                    "Peter",
                    "peter@email.com",
                    LocalDate.of(1980, Month.FEBRUARY, 17)
            );

            repository.saveAll(List.of(maria, peter));
        };
    }
}
