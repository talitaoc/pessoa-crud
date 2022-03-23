package com.talitaoc.cadastro.dtos;

import com.talitaoc.cadastro.model.PessoaModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PessoaDTO {

    private String nome;
    private Long cpf;
    private Integer idade;

    public PessoaModel convert(){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNome(this.nome);
        pessoaModel.setCpf(this.cpf);
        pessoaModel.setIdade(this.idade);

        return pessoaModel;
    }

}


