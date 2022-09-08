package com.example.StudentsAPI;

import com.example.StudentsAPI.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class StudentsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApiApplication.class, args);
	}

	@GetMapping
	public List<Student> hello() {
		return List.of(
				new Student(
						1L,
						"test@email.com",
						"Test name",
						LocalDate.of(2000, Month.FEBRUARY, 19),
						20
				),new Student(
						1L,
						"test2@email.com",
						"Test name2",
						LocalDate.of(1980, Month.FEBRUARY, 17),
						40
				)
		);
	}
}
