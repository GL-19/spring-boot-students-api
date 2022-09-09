package com.example.StudentsAPI.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("A student with this email already exists");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = studentRepository.existsById(studentId);
        if(!studentExists) {
            throw new IllegalStateException(
                    "Student with id " + studentId + " does not exist"
            );
        }
        studentRepository.deleteById(studentId);
    }
}
