package com.example.StudentsAPI.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
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
