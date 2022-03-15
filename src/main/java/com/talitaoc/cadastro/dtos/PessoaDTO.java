package com.talitaoc.cadastro.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
//@Data cria os 3 juntos
public class PessoaDTO {

    @NotNull
    private String nome;
    @NotNull
    @Size(max = 11)
    private Long cpf;
    @NotNull
    private Integer idade;


}
