package ru.letsdigit.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.letsdigit.students.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 4.
 * При старте приложения, в программе должно быть создано 5-10 студентов.
 */
@Service
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final IStudentService studentService;

    @Autowired
    public CommandLineRunnerImpl(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иван Иванов", "tech"),
                new Student("Иван Сидоров", "tech"),
                new Student("Иван Петров", "tech"),
                new Student("Петр Сидоров", "tech"),
                new Student("Петр Иванов", "it"),
                new Student("Петр Петров", "it")));

        students.forEach(studentService::save);
    }
}
