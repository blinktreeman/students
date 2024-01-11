package ru.letsdigit.students.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Student implements Serializable {

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;
    private String groupName;
}
