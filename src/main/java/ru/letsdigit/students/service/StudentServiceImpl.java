package ru.letsdigit.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.letsdigit.students.entity.Student;
import ru.letsdigit.students.repository.IStudentRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(UUID uuid) {
        return studentRepository.findById(uuid);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Iterable<Student> findAllByNameContains(String name) {
        return studentRepository.findAllByNameContains(name);
    }

    @Override
    public Iterable<Student> findAllByGroupName(String groupName) {
        return studentRepository.findAllByGroupName(groupName);
    }

    @Override
    public void deleteById(UUID uuid) {
        studentRepository.deleteById(uuid);
    }
}
