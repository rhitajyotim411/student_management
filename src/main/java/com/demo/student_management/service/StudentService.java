package com.demo.student_management.service;

import com.demo.student_management.model.Student;
import com.demo.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // get all students
    public ResponseEntity<?> getAllStudents() {
        List<Student> l = studentRepository.findAll();

        if (l.size() < 1)
            return new ResponseEntity<>("No student registered", HttpStatus.OK);
        else
            return new ResponseEntity<>(l, HttpStatus.OK);
    }

    // get student by id
    public ResponseEntity<?> getStudentById(Long id) {
        Student s = studentRepository.findById(id).orElse(null);

        if (s == null)
            return new ResponseEntity<>("No such student ID exists",
                    HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    // save student
    public ResponseEntity<?> saveStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>("Student Registered", HttpStatus.OK);
    }

    // update student
    public ResponseEntity<?> updateStudent(Student student) {
        Long id = student.getId();
        Student s = studentRepository.findById(id).orElse(null);

        if (s == null)
            return new ResponseEntity<>("No such student exists",
                    HttpStatus.BAD_REQUEST);

        studentRepository.save(student);
        return new ResponseEntity<>("Student updated", HttpStatus.OK);
    }

    // delete student by id
    public ResponseEntity<?> deleteStudentById(Long id) {
        Student s = studentRepository.findById(id).orElse(null);

        if (s == null)
            return new ResponseEntity<>("No such student ID exists",
                    HttpStatus.BAD_REQUEST);

        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }
}
