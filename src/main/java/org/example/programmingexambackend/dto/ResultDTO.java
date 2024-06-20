package org.example.programmingexambackend.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class ResultDTO {
    private Long id;
    private Long participantId;
    private Long disciplineId;
    private String resultValue;
    @Setter
    private String resultType; // This will be fetched dynamically from Discipline

}
