package org.example.programmingexambackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    private String resultValue;

    // Adding resultType based on discipline
    @Transient // This ensures JPA does not persist this field to the database
    private String resultType;

    public String getResultType() {
        if (discipline != null) {
            return discipline.getResultType();
        }
        return null;
    }
}
