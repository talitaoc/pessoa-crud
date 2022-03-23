package com.talitaoc.cadastro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CADASTRO_PESSOA", schema = "pessoa_crud")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PessoaModel {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CADASTRO_PESSOA_SEQ")
    @SequenceGenerator(name = "CADASTRO_PESSOA_SEQ", sequenceName = "pessoa_crud.CADASTRO_PESSOA_SEQ")
    private Long id;
    @Column(nullable = false, unique = false, length = 30)
    private String nome;
    @Column(nullable = false, unique = true, length = 11)
    private Long cpf;
    @Column(nullable = false, unique = false, length = 2)
    private Integer idade;


}
