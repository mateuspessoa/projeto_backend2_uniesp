package com.mateus.aluguel.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;

import com.mateus.aluguel.entity.Pessoa;

import lombok.Data;

@Data
public class PessoaClienteRequestDTO {
	
	private String nome;
	private String cpf;
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	private String numeroCartao;
	private String codigoSegurancaCartao;
	private String titularCartao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataValidade;
	
	public Pessoa converter(PessoaClienteRequestDTO pesoClienteRequestDTO) {
		Pessoa pessoa = new Pessoa();
		
		BeanUtils.copyProperties(pesoClienteRequestDTO, pessoa);
		return pessoa;
	}

}
