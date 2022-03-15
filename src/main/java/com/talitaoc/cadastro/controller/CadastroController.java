package com.talitaoc.cadastro.controller;

import com.talitaoc.cadastro.dtos.PessoaDTO;
import com.talitaoc.cadastro.model.PessoaModel;
import com.talitaoc.cadastro.services.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //para o Spring encontrar, gerenciar, receber e enviar requisições ao usuário
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    PessoaService pessoaService;

    //POST
    @PostMapping
    public void salvarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDTO,pessoaModel);
        pessoaService.save(pessoaModel);
    }

}
