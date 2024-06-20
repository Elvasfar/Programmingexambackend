package org.example.programmingexambackend;

import org.example.programmingexambackend.configuration.ResourceNotFoundException;
import org.example.programmingexambackend.dto.ResultDTO;
import org.example.programmingexambackend.entity.Discipline;
import org.example.programmingexambackend.entity.Participant;
import org.example.programmingexambackend.entity.Result;
import org.example.programmingexambackend.repository.DisciplineRepository;
import org.example.programmingexambackend.repository.ParticipantRepository;
import org.example.programmingexambackend.repository.ResultRepository;
import org.example.programmingexambackend.service.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ResultServiceIntegrationTest {

    @Mock
    private ResultRepository resultRepository;

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private DisciplineRepository disciplineRepository;

    @InjectMocks
    private ResultService resultService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createResult() {
        // Mock data
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResultValue("New Result");
        resultDTO.setParticipantId(1L);
        resultDTO.setDisciplineId(1L);

        Participant participant = new Participant();
        participant.setId(1L);

        Discipline discipline = new Discipline();
        discipline.setId(1L);

        Result result = new Result();
        result.setId(1L);
        result.setResultValue(resultDTO.getResultValue());
        result.setParticipant(participant);
        result.setDiscipline(discipline);

        when(participantRepository.findById(1L)).thenReturn(Optional.of(participant));
        when(disciplineRepository.findById(1L)).thenReturn(Optional.of(discipline));
        when(resultRepository.save(any(Result.class))).thenReturn(result);

        // Call the service method
        ResultDTO createdResultDTO = resultService.createResult(resultDTO);

        // Verify
        assertNotNull(createdResultDTO);
        assertEquals(1L, createdResultDTO.getId());
        assertEquals("New Result", createdResultDTO.getResultValue());
        assertEquals(1L, createdResultDTO.getParticipantId());
        assertEquals(1L, createdResultDTO.getDisciplineId());
        verify(participantRepository, times(1)).findById(1L);
        verify(disciplineRepository, times(1)).findById(1L);
        verify(resultRepository, times(1)).save(any(Result.class));
    }

    @Test
    void updateResult() {
        // Mock data
        Long resultId = 1L;
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setId(resultId);
        resultDTO.setResultValue("Updated Result");
        resultDTO.setParticipantId(1L);
        resultDTO.setDisciplineId(1L);

        Participant participant = new Participant();
        participant.setId(1L);

        Discipline discipline = new Discipline();
        discipline.setId(1L);

        Result existingResult = new Result();
        existingResult.setId(resultId);
        existingResult.setResultValue("Old Result");
        existingResult.setParticipant(participant);
        existingResult.setDiscipline(discipline);

        when(resultRepository.findById(resultId)).thenReturn(Optional.of(existingResult));
        when(participantRepository.findById(1L)).thenReturn(Optional.of(participant));
        when(disciplineRepository.findById(1L)).thenReturn(Optional.of(discipline));
        when(resultRepository.save(any(Result.class))).thenReturn(existingResult);

        // Call the service method
        ResultDTO updatedResultDTO = resultService.updateResult(resultId, resultDTO);

        // Verify
        assertNotNull(updatedResultDTO);
        assertEquals(resultId, updatedResultDTO.getId());
        assertEquals("Updated Result", updatedResultDTO.getResultValue());
        assertEquals(1L, updatedResultDTO.getParticipantId());
        assertEquals(1L, updatedResultDTO.getDisciplineId());
        verify(resultRepository, times(1)).findById(resultId);
        verify(participantRepository, times(1)).findById(1L);
        verify(disciplineRepository, times(1)).findById(1L);
        verify(resultRepository, times(1)).save(any(Result.class));
    }

    @Test
    void deleteResult() {
        // Mock data
        Long resultId = 1L;

        when(resultRepository.existsById(resultId)).thenReturn(true);

        // Call the service method
        resultService.deleteResult(resultId);

        // Verify
        verify(resultRepository, times(1)).existsById(resultId);
        verify(resultRepository, times(1)).deleteById(resultId);
    }

    @Test
    void deleteResult_notFound() {
        // Mock data
        Long resultId = 1L;

        when(resultRepository.existsById(resultId)).thenReturn(false);

        // Call the service method and expect ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> resultService.deleteResult(resultId));

        // Verify
        verify(resultRepository, times(1)).existsById(resultId);
        verify(resultRepository, never()).deleteById(resultId);
    }
}
