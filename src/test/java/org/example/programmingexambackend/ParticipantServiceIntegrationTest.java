package org.example.programmingexambackend;

import org.example.programmingexambackend.configuration.ResourceNotFoundException;
import org.example.programmingexambackend.dto.ParticipantDTO;
import org.example.programmingexambackend.entity.Discipline;
import org.example.programmingexambackend.entity.Participant;
import org.example.programmingexambackend.repository.DisciplineRepository;
import org.example.programmingexambackend.repository.ParticipantRepository;
import org.example.programmingexambackend.service.ParticipantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private DisciplineRepository disciplineRepository;

    @InjectMocks
    private ParticipantService participantService;

    @Test
    void getAllParticipants() {
        // Mocking the behavior of the repository
        List<Participant> participants = new ArrayList<>();
        when(participantRepository.findAll()).thenReturn(participants);

        // Calling the service method
        List<ParticipantDTO> result = participantService.getAllParticipants();

        // Verifying the result
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void getParticipantById() {
        // Mocking the behavior of the repository
        Participant participant = new Participant();
        participant.setId(1L);
        participant.setDisciplines(new ArrayList<>()); // Initialize disciplines to an empty list

        when(participantRepository.findById(1L)).thenReturn(Optional.of(participant));

        // Calling the service method
        Optional<ParticipantDTO> result = participantService.getParticipantById(1L);

        // Verifying the result
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }


    @Test
    void createParticipant() {
        // Mocking the behavior of the repository
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setName("John Doe");
        participantDTO.setGender("Male");
        participantDTO.setAge(25);
        participantDTO.setClub("ABC Club");
        participantDTO.setDisciplineIds(List.of(1L, 2L));

        Discipline discipline1 = new Discipline();
        discipline1.setId(1L);

        Discipline discipline2 = new Discipline();
        discipline2.setId(2L);

        when(disciplineRepository.findAllById(List.of(1L, 2L))).thenReturn(List.of(discipline1, discipline2));

        // Mocking save behavior
        when(participantRepository.save(any())).thenAnswer(invocation -> {
            Participant participant = invocation.getArgument(0);
            participant.setId(1L); // Mocking ID generation
            return participant;
        });

        // Calling the service method
        ParticipantDTO result = participantService.createParticipant(participantDTO);

        // Verifying the result
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("Male", result.getGender());
        assertEquals(25, result.getAge());
        assertEquals("ABC Club", result.getClub());
        assertEquals(2, result.getDisciplineIds().size());
        assertTrue(result.getDisciplineIds().contains(1L));
        assertTrue(result.getDisciplineIds().contains(2L));
    }

    @Test
    void updateParticipant() {
        // Mock data
        Long participantId = 1L;
        List<Long> disciplineIds = Arrays.asList(1L, 2L);
        ParticipantDTO participantDTO = new ParticipantDTO();
        participantDTO.setId(participantId);
        participantDTO.setName("Updated Name");
        participantDTO.setGender("Male");
        participantDTO.setAge(30);
        participantDTO.setClub("Updated Club");
        participantDTO.setDisciplineIds(disciplineIds);

        Participant existingParticipant = new Participant();
        existingParticipant.setId(participantId);
        existingParticipant.setName("Old Name");
        existingParticipant.setGender("Female");
        existingParticipant.setAge(25);
        existingParticipant.setClub("Old Club");

        Discipline discipline1 = new Discipline();
        discipline1.setId(1L);
        discipline1.setDisciplineName("Discipline 1");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2L);
        discipline2.setDisciplineName("Discipline 2");

        when(participantRepository.findById(participantId)).thenReturn(Optional.of(existingParticipant));
        when(disciplineRepository.findAllById(disciplineIds)).thenReturn(Arrays.asList(discipline1, discipline2));
        when(participantRepository.save(any(Participant.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Call the service method
        ParticipantDTO updatedParticipantDTO = participantService.updateParticipant(participantId, participantDTO);

        // Verify
        assertEquals(participantId, updatedParticipantDTO.getId());
        assertEquals("Updated Name", updatedParticipantDTO.getName());
        assertEquals("Male", updatedParticipantDTO.getGender());
        assertEquals(30, updatedParticipantDTO.getAge());
        assertEquals("Updated Club", updatedParticipantDTO.getClub());
        assertEquals(disciplineIds, updatedParticipantDTO.getDisciplineIds());
        verify(participantRepository, times(1)).findById(participantId);
        verify(disciplineRepository, times(1)).findAllById(disciplineIds);
        verify(participantRepository, times(1)).save(any(Participant.class));
    }

    @Test
    void deleteParticipant_success() {
        // Mock data
        Long participantId = 1L;
        Participant participant = new Participant();
        participant.setId(participantId);

        when(participantRepository.existsById(participantId)).thenReturn(true);

        // Call the service method
        participantService.deleteParticipant(participantId);

        // Verify
        verify(participantRepository, times(1)).existsById(participantId);
        verify(participantRepository, times(1)).deleteById(participantId);
    }

    @Test
    void deleteParticipant_notFound() {
        // Mock data
        Long participantId = 1L;

        when(participantRepository.existsById(participantId)).thenReturn(false);

        // Call the service method and expect ResourceNotFoundException
        assertThrows(ResourceNotFoundException.class, () -> participantService.deleteParticipant(participantId));

        // Verify
        verify(participantRepository, times(1)).existsById(participantId);
        verify(participantRepository, never()).deleteById(participantId);
    }
}
