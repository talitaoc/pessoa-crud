package com.talitaoc.cadastro.repositories;

import com.talitaoc.cadastro.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//utilização do JpaRepository já possui vários métodos prontos para repositorio

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Integer> {

    boolean existsByCpf(Long cpf);
    PessoaModel findByCpf(Long cpf);
    PessoaModel findByIdAndCpf(Integer id, Long cpf);
}
