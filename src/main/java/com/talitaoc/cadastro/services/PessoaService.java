package com.talitaoc.cadastro.services;


import com.talitaoc.cadastro.exception.UserNotFoundException;
import com.talitaoc.cadastro.model.PessoaModel;
import com.talitaoc.cadastro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    public void delete(PessoaModel pessoaModel) {
        pessoaRepository.delete(pessoaModel);
    }

    public boolean existsByCpf(Long cpf) {
        return pessoaRepository.existsByCpf(cpf);
    }


    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }

    public PessoaModel getPessoa(Integer id, Long cpf) throws UserNotFoundException {

        PessoaModel pessoaModel = null;

        if (Objects.nonNull(id) && Objects.nonNull(cpf)) {
            pessoaModel =  pessoaRepository.findByIdAndCpf(id, cpf);
        } else if (Objects.nonNull(id) || Objects.nonNull(cpf)) {
            if (Objects.nonNull(id)) {
                pessoaModel =  pessoaRepository.getById(id);//alterar
            } else if (Objects.nonNull(cpf)) {
                pessoaModel =  pessoaRepository.findByCpf(cpf);
            }
        }
        if(Objects.isNull(pessoaModel)){
            throw new UserNotFoundException();
        }
        return pessoaModel;
    }
}