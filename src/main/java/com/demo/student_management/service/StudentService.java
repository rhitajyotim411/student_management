package com.demo.student_management.service;

import com.demo.student_management.model.Student;
import com.demo.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<String> getAllStudents() {
        List<Student> l = studentRepository.findAll();
        String mssg;

        if (l.size() < 1)
            mssg = "No student registered";
        else
            mssg = l.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\n"));

        return new ResponseEntity<>(mssg, HttpStatus.OK);
    }

    public ResponseEntity<String> saveStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>("Student Registered", HttpStatus.OK);
    }

    public ResponseEntity<String> getStudentById(Long id) {
        Student s = studentRepository.findById(id).orElse(null);

        if (s == null)
            return new ResponseEntity<>("No such student ID exists",
                    HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(s.toString(), HttpStatus.OK);
    }

    public ResponseEntity<String> updateStudent(Student student) {
        Long id = student.getId();
        Student s = studentRepository.findById(id).orElse(null);

        if (s == null)
            return new ResponseEntity<>("No such student exists",
                    HttpStatus.BAD_REQUEST);

        studentRepository.save(student);
        return new ResponseEntity<>("Student updated", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudentById(Long id) {
        Student s = studentRepository.findById(id).orElse(null);

        if (s == null)
            return new ResponseEntity<>("No such student ID exists",
                    HttpStatus.BAD_REQUEST);

        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }
}
