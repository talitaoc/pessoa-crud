package com.talitaoc.cadastro.controller;

import com.talitaoc.cadastro.dtos.PessoaDTO;
import com.talitaoc.cadastro.exception.UserNotFoundException;
import com.talitaoc.cadastro.model.PessoaModel;
import com.talitaoc.cadastro.services.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public void salvarPessoa(@RequestBody PessoaDTO pessoaDTO){
        if(pessoaService.existsByCpf(pessoaDTO.getCpf())){
            log.info("Usuário já existe {}", pessoaDTO);
        }
        PessoaModel pessoaModel = pessoaDTO.convert();
        pessoaService.save(pessoaModel);
    }

    @GetMapping("/listar")
    public List<PessoaModel> getAllPessoaModels(){
        return pessoaService.findAll();
    }

    @GetMapping
    public PessoaModel getOnePessoaModel(@RequestParam (value = "id", required = false) Integer id, @RequestParam (value = "cpf", required = false) Long cpf) throws UserNotFoundException {
        return pessoaService.getPessoa(id,cpf);
    }

    @DeleteMapping
    public void deletePessoaModel(@RequestParam (value = "id", required = false) Integer id,@RequestParam (value = "cpf", required = false) Long cpf) throws UserNotFoundException {
        pessoaService.delete(pessoaService.getPessoa(id,cpf));

    }

    @PutMapping
    public PessoaModel updatePessoa(@RequestBody @Valid PessoaDTO pessoaDTO) throws UserNotFoundException {
        PessoaModel pessoaModel = pessoaService.getPessoa(null, pessoaDTO.getCpf());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setCpf(pessoaDTO.getCpf());
        pessoaModel.setIdade(pessoaDTO.getIdade());
        log.info("Usuário atualizado {}", pessoaModel);

        return pessoaService.save(pessoaModel);

    }

}
