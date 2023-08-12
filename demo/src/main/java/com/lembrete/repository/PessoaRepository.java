package com.lembrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lembrete.entity.Pessoa;
import java.util.List;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	

    @Query("SELECT p FROM Pessoa p WHERE p.nome = :nome")
    Pessoa findByNome(String nome);
}