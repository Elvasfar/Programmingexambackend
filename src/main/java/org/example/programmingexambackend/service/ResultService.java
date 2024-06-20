package org.example.programmingexambackend.service;

import org.example.programmingexambackend.configuration.ResourceNotFoundException;
import org.example.programmingexambackend.dto.ResultDTO;
import org.example.programmingexambackend.entity.Discipline;
import org.example.programmingexambackend.entity.Participant;
import org.example.programmingexambackend.entity.Result;
import org.example.programmingexambackend.repository.DisciplineRepository;
import org.example.programmingexambackend.repository.ParticipantRepository;
import org.example.programmingexambackend.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<ResultDTO> getAllResults() {
        return resultRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ResultDTO> getResultById(Long id) {
        return resultRepository.findById(id)
                .map(this::convertToDTO);
    }

    public ResultDTO createResult(ResultDTO resultDTO) {
        Result result = convertToEntity(resultDTO);

        Participant participant = participantRepository.findById(resultDTO.getParticipantId())
                .orElseThrow(() -> new ResourceNotFoundException("Participant not found with id: " + resultDTO.getParticipantId()));
        result.setParticipant(participant);

        Discipline discipline = disciplineRepository.findById(resultDTO.getDisciplineId())
                .orElseThrow(() -> new ResourceNotFoundException("Discipline not found with id: " + resultDTO.getDisciplineId()));
        result.setDiscipline(discipline);

        result = resultRepository.save(result);
        resultDTO.setResultType(result.getResultType()); // Set dynamically fetched resultType
        return convertToDTO(result);
    }

    public ResultDTO updateResult(Long id, ResultDTO resultDTO) {
        Result existingResult = resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found with id: " + id));

        existingResult.setResultValue(resultDTO.getResultValue());

        Participant participant = participantRepository.findById(resultDTO.getParticipantId())
                .orElseThrow(() -> new ResourceNotFoundException("Participant not found with id: " + resultDTO.getParticipantId()));
        existingResult.setParticipant(participant);

        Discipline discipline = disciplineRepository.findById(resultDTO.getDisciplineId())
                .orElseThrow(() -> new ResourceNotFoundException("Discipline not found with id: " + resultDTO.getDisciplineId()));
        existingResult.setDiscipline(discipline);

        existingResult = resultRepository.save(existingResult);
        resultDTO.setResultType(existingResult.getResultType()); // Set dynamically fetched resultType
        return convertToDTO(existingResult);
    }

    public void deleteResult(Long id) {
        if (!resultRepository.existsById(id)) {
            throw new ResourceNotFoundException("Result not found with id: " + id);
        }
        resultRepository.deleteById(id);
    }

    private ResultDTO convertToDTO(Result result) {
        ResultDTO dto = new ResultDTO();
        dto.setId(result.getId());
        dto.setResultValue(result.getResultValue());
        dto.setParticipantId(result.getParticipant().getId());
        dto.setDisciplineId(result.getDiscipline().getId());
        dto.setResultType(result.getResultType()); // Set dynamically fetched resultType
        return dto;
    }

    private Result convertToEntity(ResultDTO dto) {
        Result result = new Result();
        result.setResultValue(dto.getResultValue());
        // Participant and discipline should be handled separately
        return result;
    }
}
