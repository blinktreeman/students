package ru.letsdigit.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.letsdigit.students.entity.Student;

import java.util.UUID;

@Repository
public interface IStudentRepository extends JpaRepository<Student, UUID> {
    Iterable<Student> findAllByNameContaining(String name);
    Iterable<Student> findAllByGroupName(String groupName);
}
