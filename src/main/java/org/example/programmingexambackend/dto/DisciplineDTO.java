package org.example.programmingexambackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class DisciplineDTO {
    private Long id;
    private String disciplineName;
    private String resultType;
    private List<Long> participantIds;
    private List<ResultDTO> results;
}
