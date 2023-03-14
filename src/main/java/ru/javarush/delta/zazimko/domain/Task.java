package ru.javarush.delta.zazimko.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task", schema = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.ORDINAL)
    //@Column(name="status", columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Status status;
}
