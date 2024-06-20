package org.example.programmingexambackend;

import org.example.programmingexambackend.configuration.ResourceNotFoundException;
import org.example.programmingexambackend.dto.DisciplineDTO;
import org.example.programmingexambackend.entity.Discipline;
import org.example.programmingexambackend.repository.DisciplineRepository;
import org.example.programmingexambackend.service.DisciplineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DisciplineServiceIntegrationTest {

    @Mock
    private DisciplineRepository disciplineRepository;

    @InjectMocks
    private DisciplineService disciplineService;

    private Discipline discipline1;
    private Discipline discipline2;

    @BeforeEach
    public void setUp() {
        discipline1 = new Discipline();
        discipline1.setId(1L);
        discipline1.setDisciplineName("Discipline 1");
        discipline1.setResultType("points");

        discipline2 = new Discipline();
        discipline2.setId(2L);
        discipline2.setDisciplineName("Discipline 2");
        discipline2.setResultType("length");
    }

    @Test
    public void testGetAllDisciplines() {
        when(disciplineRepository.findAll()).thenReturn(Arrays.asList(discipline1, discipline2));

        List<DisciplineDTO> result = disciplineService.getAllDisciplines();

        assertEquals(2, result.size());
        assertEquals("Discipline 1", result.get(0).getDisciplineName());
        assertEquals("length", result.get(1).getResultType());
    }

    @Test
    public void testGetDisciplineById() {
        when(disciplineRepository.findById(1L)).thenReturn(Optional.of(discipline1));

        Optional<DisciplineDTO> result = disciplineService.getDisciplineById(1L);

        assertTrue(result.isPresent());
        assertEquals("Discipline 1", result.get().getDisciplineName());
        assertEquals("points", result.get().getResultType());
    }

    @Test
    public void testCreateDiscipline() {
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        disciplineDTO.setDisciplineName("New Discipline");
        disciplineDTO.setResultType("HH:MM:SS:SSS");

        Discipline discipline = new Discipline();
        discipline.setId(3L);
        discipline.setDisciplineName("New Discipline");
        discipline.setResultType("HH:MM:SS:SSS");

        when(disciplineRepository.save(any(Discipline.class))).thenReturn(discipline);

        DisciplineDTO result = disciplineService.createDiscipline(disciplineDTO);

        assertNotNull(result);
        assertEquals(3L, result.getId());
        assertEquals("New Discipline", result.getDisciplineName());
        assertEquals("HH:MM:SS:SSS", result.getResultType());
    }

    @Test
    public void testUpdateDiscipline() {
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        disciplineDTO.setDisciplineName("Updated Discipline");
        disciplineDTO.setResultType("length");

        Discipline existingDiscipline = new Discipline();
        existingDiscipline.setId(1L);
        existingDiscipline.setDisciplineName("Discipline 1");
        existingDiscipline.setResultType("points");

        when(disciplineRepository.findById(1L)).thenReturn(Optional.of(existingDiscipline));
        when(disciplineRepository.save(any(Discipline.class))).thenAnswer(invocation -> invocation.getArgument(0));

        DisciplineDTO result = disciplineService.updateDiscipline(1L, disciplineDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Updated Discipline", result.getDisciplineName());
        assertEquals("length", result.getResultType());
    }

    @Test
    public void testDeleteDiscipline() {
        when(disciplineRepository.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> disciplineService.deleteDiscipline(1L));
    }

    @Test
    public void testDeleteDiscipline_NotFound() {
        when(disciplineRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> disciplineService.deleteDiscipline(1L));
    }
}
