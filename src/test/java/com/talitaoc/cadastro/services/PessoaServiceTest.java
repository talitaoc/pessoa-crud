package com.talitaoc.cadastro.services;

import com.talitaoc.cadastro.exception.UserNotFoundException;
import com.talitaoc.cadastro.model.PessoaModel;
import com.talitaoc.cadastro.repositories.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PessoaServiceTest {

    @SpyBean
    private PessoaService pessoaService;
    @MockBean
    private PessoaRepository pessoaRepository;

    @Test
    void whenFindByIdAndCpfFoundReturnUser() throws UserNotFoundException {
        when(pessoaRepository.findByIdAndCpf(1,1L)).thenReturn(new PessoaModel(1L,"Talita", 1L, 34));

        PessoaModel pessoaModel = pessoaService.getPessoa(1,1L);

        assertNotNull(pessoaModel);

        verify(pessoaRepository, times(1)).findByIdAndCpf(1,1L);
        verify(pessoaRepository, never()).getById(1);
        verify(pessoaRepository, never()).findByCpf(1L);
    }

    @Test
    void whenFindByIdFoundReturnUser() throws UserNotFoundException{
        when(pessoaRepository.getById(1)).thenReturn(new PessoaModel(1L, "Talita", null, 34));

        PessoaModel pessoaModel = pessoaService.getPessoa(1, null);
        assertNotNull(pessoaModel);

        verify(pessoaRepository,times(1)).getById(1);
        verify(pessoaRepository, never()).findByCpf(1L);
        verify(pessoaRepository, never()).findByIdAndCpf(1, null);

    }
    @Test
    void whenFindByCpdFoundReturnUser() throws UserNotFoundException{
        when(pessoaRepository.findByCpf(1L)).thenReturn(new PessoaModel(null, "Talita", 1L, 34));

        PessoaModel pessoaModel = pessoaService.getPessoa(null, 1L);
        assertNotNull(pessoaModel);

        verify(pessoaRepository, times(1)).findByCpf(1L);
        verify(pessoaRepository, never()).getById(1);
        verify(pessoaRepository, never()).findByIdAndCpf(1,1L);
    }

    @Test
    void whenUserNotFoundThrowError() throws UserNotFoundException{
        assertThrows(UserNotFoundException.class, ()-> pessoaService.getPessoa(null,null));
    }

    @Test
    void whenIdAndCpfIsNullThrowException(){
        assertThrows(UserNotFoundException.class, ()-> pessoaService.getPessoa(null,null));
    }

}