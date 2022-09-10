package com.example.StudentsAPI.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = this.studentRepository
                .findByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("A student with this email already exists");
        }

        this.studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean studentExists = this.studentRepository.existsById(studentId);
        if(!studentExists) {
            throw new IllegalStateException(
                    "Student with id " + studentId + " does not exist"
            );
        }
        this.studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + "does not exist"
                ));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = this.studentRepository.findByEmail(email);

            if(studentOptional.isPresent()) {
                throw new IllegalStateException(
                        "Student with email " + email + "already exists"
                );
            }

            student.setEmail(email);
        }
    }
}
