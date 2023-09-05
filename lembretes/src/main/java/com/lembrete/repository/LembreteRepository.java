package com.lembrete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lembrete.entity.Lembrete;


public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
	
	@Query("SELECT l FROM Lembrete l WHERE l.pessoa.nome = :nomePessoa")
	List<Lembrete> findAllLembretesByNomePessoa(String nomePessoa);
}
