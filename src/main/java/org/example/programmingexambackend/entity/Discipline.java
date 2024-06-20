package org.example.programmingexambackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disciplineName;

    // New property
    private String resultType; // Possible values: "points", "length", "HH:MM:SS:SSS"

    @ManyToMany(mappedBy = "disciplines")
    private List<Participant> participants;

    @OneToMany(mappedBy = "discipline")
    private List<Result> results;
}
