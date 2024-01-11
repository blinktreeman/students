package ru.letsdigit.students.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;
    private String groupName;
}
