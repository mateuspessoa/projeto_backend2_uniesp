package com.mateus.aluguel.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.dto.PessoaClienteRequestDTO;
import com.mateus.aluguel.entity.Pessoa;
import com.mateus.aluguel.repository.PessoaClienteRepository;


@Service
public class PessoaClienteService {
	
	@Autowired
	private PessoaClienteRepository pessoaRepository;
	
	@Autowired
	private PermissaoPessoaService permissaoPessoaService;
	
	
	public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
		pessoa.setDataCriacao(new Date());
		Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
		permissaoPessoaService.vincularPessoaPermissaoCLiente(pessoaNova);
		return pessoaNova;
	}
	
	public Pessoa atualizarDados(Long pessoaId, PessoaClienteRequestDTO pessoaClienteRequestDTO) {
		Pessoa pessoaExistente = pessoaRepository.findById(pessoaId)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

		BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoaExistente, "id", "dataCriacao");

		Pessoa pessoaAtualizada = pessoaRepository.save(pessoaExistente);

		return pessoaAtualizada;
	}

}
