package com.lembrete;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lembrete.DTO.PessoaDTO;
import com.lembrete.controller.PessoaController;
import com.lembrete.entity.Lembrete;
import com.lembrete.entity.Pessoa;
import com.lembrete.repository.PessoaRepository;
import com.lembrete.service.LembreteService;
import com.lembrete.service.PessoaService;
import com.lembrete.repository.LembreteRepository;

@SpringBootTest
class DemoApplicationTests {

	@MockBean
	PessoaRepository pessoaRepository;
	
	@MockBean
	LembreteRepository lembreteRepository;
	
	private PessoaService pessoaService = new PessoaService();

	private LembreteService lembreteService = new LembreteService();
	
	@BeforeEach
	void injectPessoaFindAll() {

		List<Pessoa> pessoas = new ArrayList<>();
		Pessoa pessoa = new Pessoa(1l, "Rubens");
		pessoas.add(pessoa);
		Mockito.when(pessoaRepository.findAll()).thenReturn(pessoas);
	}
	@BeforeEach
	void injectLembreteFindAll() {

		List<Lembrete> lembretes = new ArrayList<>();
		Lembrete lembrete = new Lembrete();
		lembretes.add(lembrete);
		Mockito.when(lembreteRepository.findAll()).thenReturn(lembretes);
	}	

	
	@Test
	void testeServicePessoaFindAll() {

		List<Pessoa> pessoas = new ArrayList<>();
		Pessoa pessoa = new Pessoa(1l, "Rubens");
		List<Pessoa> resultado = pessoaService.findAll();
		resultado.add(pessoa);

		assertEquals(pessoas, resultado);
	}	
	@Test
	void testeServiceLembreteFindAll() {

		List<Lembrete> lembretes = new ArrayList<>();
		Lembrete lembrete = new Lembrete();
		List<Lembrete> resultado = lembreteService.findAll();
		resultado.add(lembrete);

		assertEquals(lembretes, resultado);
	}	

}
