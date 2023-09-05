package com.lembrete.DTO;

import lombok.Data;

@Data
public class LembreteDTO {
	private long id;
	
	private String mensagem;

	private PessoaDTO pessoa;

}
