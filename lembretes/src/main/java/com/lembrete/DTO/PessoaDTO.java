package com.lembrete.DTO;

import lombok.Data;

@Data
public class PessoaDTO {

	private long id;
	
	private String nome;
	
	 public PessoaDTO(long id, String nome) {
	        this.id = id;
	        this.nome = nome;
	    }
}
