package com.lembrete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lembrete.entity.Pessoa;
import com.lembrete.entity.Lembrete;

import com.lembrete.repository.LembreteRepository;
import com.lembrete.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	@Autowired
	private LembreteRepository lRepository;
	
	public List<Pessoa> findAll(){
		return repository.findAll();
	}
	
	public List<Lembrete> findPessoa(String nome){
		return lRepository.findAllLembretesByNomePessoa(nome);
	}
	
	public ResponseEntity<Pessoa> include(Pessoa pessoa) {
        Assert.isTrue(pessoa.getNome() != null, "Nome não informado");
        Assert.isTrue(repository.findByNome(pessoa.getNome()) == null, "pessoa já cadastrada");
		repository.save(pessoa);
        return ResponseEntity.ok(pessoa);
	}
	
	public ResponseEntity<Pessoa> edit(Long id, Pessoa pessoa){

        Assert.isTrue(pessoa.getNome() != null, "nome nao informado");

        final Pessoa pessoaBanco = this.repository.findById(id).orElse(null);
        Assert.isTrue(pessoaBanco != null, "nao foi possivel encontrar o registro");
        Assert.isTrue(pessoaBanco.getId() != pessoa.getId(),"Os registros não coincidem");
        pessoaBanco.setNome(pessoa.getNome());
        
        repository.save(pessoaBanco);
        return ResponseEntity.ok(pessoaBanco);

    }

	public void delete(Long id){
        Pessoa pessoaBanco = this.repository.findById(id).orElse(null);
        Assert.isTrue(pessoaBanco != null, "nao foi possivel encontrar o registro");
        this.repository.deleteById(id);
		
	}
	
	


}