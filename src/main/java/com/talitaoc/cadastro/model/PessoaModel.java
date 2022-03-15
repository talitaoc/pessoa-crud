package com.talitaoc.cadastro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity// informar que uma classe é uma entidade, liga a entidade a tabela do banco
@Table(name = "CADASTRO_PESSOA")
@Getter //cria getters e setters
@ToString
@AllArgsConstructor //cria construtor
@NoArgsConstructor //construtor vazio
public class PessoaModel {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,unique = true,length = 30)
    private String nome;
    @Column(nullable = false,unique = false,length = 11)
    private Long cpf;
    @Column(nullable = false,unique = false,length = 2)
    private Integer idade;


}
