package ru.letsdigit.students.service;

import ru.letsdigit.students.entity.Student;

import java.util.Optional;
import java.util.UUID;

public interface IStudentService {
    Student save(Student student);
    Optional<Student> findById(UUID uuid);
    Iterable<Student> findAll();
    Iterable<Student> findAllByNameContaining(String name);
    Iterable<Student> findAllByGroupName(String groupName);
    void deleteById(UUID uuid);
}
