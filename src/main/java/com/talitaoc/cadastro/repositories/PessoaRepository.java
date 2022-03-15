package com.talitaoc.cadastro.repositories;

import com.talitaoc.cadastro.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//utilização do JpaRepository já possui vários métodos prontos para repositorio

@Repository //logica de acesso a dados que instrui o Spring, transação com base de dados
public interface PessoaRepository extends JpaRepository<PessoaModel, UUID> {


}
