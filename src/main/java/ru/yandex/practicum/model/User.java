package ru.yandex.practicum.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @UniqueElements
    private String email;
    private String name;
    @OneToMany(mappedBy = "assignee", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Task> tasks = new HashSet<>();
}
