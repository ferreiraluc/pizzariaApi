package com.lm.apipizzaria.service.testes;

import com.lm.apipizzaria.entity.Funcionario;
import com.lm.apipizzaria.repository.FuncionarioRepository;
import com.lm.apipizzaria.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFuncionarios() {
        Funcionario funcionario = new Funcionario("Lucas", "123456789", "Rua XYZ");
        when(funcionarioRepository.findAll()).thenReturn(Arrays.asList(funcionario));

        List<Funcionario> result = funcionarioService.getAllFuncionarios();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(funcionario, result.get(0));
    }

    @Test
    void testGetFuncionarioById() {
        Funcionario funcionario = new Funcionario("Lucas", "123456789", "Rua XYZ");
        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario));

        Optional<Funcionario> result = funcionarioService.getFuncionarioById(1L);

        assertTrue(result.isPresent());
        assertEquals(funcionario, result.get());
    }

    @Test
    void testSaveFuncionario() {
        Funcionario funcionario = new Funcionario("Lucas", "123456789", "Rua XYZ");
        when(funcionarioRepository.save(funcionario)).thenReturn(funcionario);

        Funcionario result = funcionarioService.saveFuncionario(funcionario);

        assertNotNull(result);
        assertEquals(funcionario, result);
    }

    @Test
    void testUpdateFuncionario() {
        Funcionario oldFuncionario = new Funcionario("Lucas", "123456789", "Rua XYZ");
        Funcionario newFuncionario = new Funcionario("Lucas Updated", "987654321", "Rua ABC");

        when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(oldFuncionario));
        when(funcionarioRepository.save(oldFuncionario)).thenReturn(oldFuncionario);

        Optional<Funcionario> result = funcionarioService.updateFuncionario(1L, newFuncionario);

        assertTrue(result.isPresent());
        assertEquals("Lucas Updated", result.get().getNome());
        assertEquals("987654321", result.get().getTelefone());
        assertEquals("Rua ABC", result.get().getEndereco());
    }

    @Test
    void testDeleteFuncionario() {
        doNothing().when(funcionarioRepository).deleteById(1L);

        funcionarioService.deleteFuncionario(1L);

        verify(funcionarioRepository, times(1)).deleteById(1L);
    }
}
