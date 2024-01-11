package ru.letsdigit.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.letsdigit.students.entity.Student;
import ru.letsdigit.students.service.IStudentService;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/student")
public class StudentController implements IStudentController {

    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    /* 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman) */
    @PostMapping
    @Override
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    /* 3.1 GET /student/{id} - получить студента по ID */
    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Student> findById(@PathVariable UUID id) {
        Optional<Student> student = studentService.findById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* 3.2 GET /student - получить всех студентов */
    @GetMapping
    @Override
    public ResponseEntity<Iterable<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    /*
     * 3.3 GET /student/search?name='studentName' - получить список студентов,
     * чье имя содержит подстроку studentName
     */
    @GetMapping(value = "/search")
    @Override
    public ResponseEntity<Iterable<Student>> findAllByNameContains(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(studentService.findAllByNameContains(name), HttpStatus.OK);
    }

    /* 3.4 GET /group/{groupName}/student - получить всех студентов группы */
    /* !! Изменено на /student/{groupName}/students */
    @GetMapping(value = "/{groupName}/students")
    @Override
    public ResponseEntity<Iterable<Student>> findAllByGroupName(@PathVariable String groupName) {
        return new ResponseEntity<>(studentService.findAllByGroupName(groupName), HttpStatus.OK);
    }

    /* 3.6 DELETE /student/{id} - удалить студента */
    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteById(@PathVariable UUID id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
