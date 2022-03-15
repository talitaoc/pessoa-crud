package com.talitaoc.cadastro.services;


import com.talitaoc.cadastro.model.PessoaModel;
import com.talitaoc.cadastro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessoaService {

    @Autowired //Spring cria uma instancia
    PessoaRepository pessoaRepository;

    @Transactional //garante o rollback caso algo dê errado
    public PessoaModel save(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }


}
