package ru.letsdigit.students.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.letsdigit.students.entity.Student;

import java.util.Collection;
import java.util.UUID;

public interface IStudentController {
    ResponseEntity<Student> save(Student student);
    ResponseEntity<Student> findById(UUID uuid);
    ResponseEntity<Iterable<Student>> findAll();
    ResponseEntity<Iterable<Student>> findAllByNameContaining(String name);
    ResponseEntity<Iterable<Student>> findAllByGroupName(String groupName);
    ResponseEntity<HttpStatus> deleteById(UUID uuid);
}
